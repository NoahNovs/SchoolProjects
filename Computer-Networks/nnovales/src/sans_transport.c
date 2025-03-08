#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <unistd.h>
#include <errno.h>
#include "include/hw5.h"
#include "include/rudp.h"

#define MAX_PACKET 1400
extern void enqueue_packet(int socket, rudp_packet_t* packet, int len);
int globalSeqNum = 0;
rudp_packet_t temp;

int sans_send_pkt(int socket, const char* buf, int len) {
    if(len > MAX_PACKET) return -1;

    //Function MUST build a rudp_packet_t out of the provided data
    int packet_size = sizeof(rudp_packet_t) + len;
    rudp_packet_t *packet = (rudp_packet_t*)malloc(packet_size);
    if(!packet) return -1;

    packet->type = DAT;
    packet->seqnum = globalSeqNum;
    memcpy(packet->payload, buf, len);
    //Function MUST enqueue the packet to the send_window (See sans_backend.c)
    enqueue_packet(socket, packet, len);
    globalSeqNum++;
    free(packet);
    return 1;

    // struct timeval timeOut2 = {
    //     .tv_usec = 20000
    // };
    // if(len > MAX_PACKET) return -1;

    // //Function MUST send data as a rudp_packet_t structure
    // rudp_packet_t *packet = malloc(sizeof(rudp_packet_t) + len);
    // rudp_packet_t ackPacket = {0};
    // struct sockaddr_storage addr;
    // socklen_t addr_len = sizeof(addr);
    // if(!packet) return -1;

    // packet->type = DAT;
    // //Function MUST track a sequence number
    // packet->seqnum = globalSeqNum;
    // memcpy(packet->payload, buf, len);
    // //Function MUST retransmit on timeout or incorrect sequence number
    // setsockopt(socket, SOL_SOCKET, SO_RCVTIMEO, &timeOut2, sizeof(timeOut2));

    // while(1){
    //     //Function MUST call sendto to transmit the buffer
    //     ssize_t send = sendto(socket, packet, sizeof(rudp_packet_t) + len, 0, (struct sockaddr*)&addr, addr_len);
    //     if(send == -1){
    //         free(packet);
    //         return -1;
    //     }
    //     ssize_t receive = recvfrom(socket, &ackPacket, sizeof(ackPacket), 0, (struct sockaddr *)&addr, &addr_len);
    //     if(receive == -1){
    //         if(errno == EAGAIN || errno == EWOULDBLOCK) continue;
    //         else{
    //             free(packet);
    //             return -1;
    //         }
    //     }
    
    //     //Function MUST only return once an ACK packet with the correct sequence
    //     if(ackPacket.type == ACK && ackPacket.seqnum == packet->seqnum){
    //         temp = *packet;
    //         globalSeqNum++;
    //         free(packet);
    //         break;
    //     }
    // }

    // return 0;
}

int sans_recv_pkt(int socket, char* buf, int len) {
//  Function MUST receive data as a rudp_packet_t structure
    record key = socketRecord[socket];
    rudp_packet_t packet = {0};
    rudp_packet_t ackPacket = {0};
    struct sockaddr_storage addr;
    socklen_t addr_len = sizeof(addr);
    while(1){
        //  Function MUST call recvfrom to receive to the buffer
        if(recvfrom(socket, &packet, sizeof(rudp_packet_t) + len, 0, (struct sockaddr*)&addr, &addr_len) == -1) return -1;
        if(packet.type == DAT && packet.seqnum == key.seqnum){
            memcpy(buf, packet.payload, len);
            ackPacket.type = ACK;
            //  Function MUST track a sequence number
            ackPacket.seqnum = key.seqnum;
            sendto(socket, &ackPacket, sizeof(rudp_packet_t), 0, (struct sockaddr*)&addr, addr_len);
            key.seqnum++;
            socketRecord[socket] = key;
            return len;
        }
        else{
            //Function MUST acknowledge the last valid packet on packet receipt
            ackPacket.type = ACK;
            ackPacket.seqnum = key.seqnum - 1;
            sendto(socket, &ackPacket, sizeof(rudp_packet_t), 0, (struct sockaddr*)&addr, addr_len);
        }
    }
    return 0;
}