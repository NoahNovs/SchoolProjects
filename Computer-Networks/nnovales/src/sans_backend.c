#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <errno.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <unistd.h>
#include "include/rudp.h"

#define SWND_SIZE 10
extern int sans_recv_pkt(int socket, char* buf, int len);

typedef struct {
  int socket;
  int packetlen;
  rudp_packet_t* packet;
} swnd_entry_t;

swnd_entry_t send_window[SWND_SIZE] = {0};  /*  Ring buffer containing the packets awaiting acknowledgement */

static int sent = 0;
static int count = 0;
static int head = 0;

/*
 * Helper: We recommend writing a helper function for pushing a packet onto the ring buffer
 *         that can be called from the main thread.
 *    (Remember to copy the packet to avoid thread conflicts!)
 */
void enqueue_packet(int sock, rudp_packet_t* pkt, int len) {
  size_t packet_size = sizeof(rudp_packet_t) + len;
  rudp_packet_t *new_pkt = (rudp_packet_t *)malloc(packet_size);
  memcpy(new_pkt, pkt, packet_size);

  int tail = (head + count) % SWND_SIZE;
  send_window[tail].socket = sock;
  send_window[tail].packet = new_pkt;
  send_window[tail].packetlen = len;
  count++;

}

/*
 * Helper: We recommend writing a helper function for removing a completed packet from the ring
 *         buffer that can be called from the backend thread.
 */
static void dequeue_packet(void) {

  free(send_window[head].packet);
  send_window[head].packet = NULL;
  head = (head + 1) % SWND_SIZE;
  count--;
  sent--;
}

/*  Asynchronous runner for the sans protocol driver.  This function  *
 *  is responsible for checking for packets in the `send_window` and  *
 *  handling the transmission of these packets in a reliable manner.  *
 *  (i.e. Stop-and-Wait or Go-Back-N)                                 */
void* sans_backend(void* unused) {
  // Function MUST perform the following forever
  while (1) {
    /* ---- Background worker code ---- */
    while (sent < count)
    {
      int index = (head + sent) % SWND_SIZE;

      // Function MUST send all pending, unsent packets in the send_window
      if(sendto(send_window[index].socket, send_window[index].packet, send_window[index].packetlen, 0 , NULL, 0) < 0) break;

      sent++;
    }
    if (count > 0){
      rudp_packet_t response;

      //Function MUST attempt to receive an acknowledgement from the remote host
      int recv_bytes = recvfrom(send_window[head].socket, &response, sizeof(rudp_packet_t), 0, NULL, NULL);
      //If acknowledgement times out, function MUST re-send all packets in the send_window
      if(recv_bytes < 0){
        sent = 0;
        continue;
      }
      if(response.type != ACK) continue;
      if(response.seqnum != send_window[head].packet->seqnum) continue;

      //If acknowledgement is correct, function MUST remove the acknowledged packet from the send_window
      dequeue_packet();
    }
    usleep(1000);
    
    
    /*----------------------------------*/
  }
  return NULL;
}
