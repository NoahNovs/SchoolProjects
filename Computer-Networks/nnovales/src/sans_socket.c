#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <sys/types.h>
#include <unistd.h>
#include <errno.h>
#include "include/rudp.h"
#include "include/sans.h"
#include "include/hw5.h"
#include <string.h>

#define MAX_SOCKETS 10
#define PKT_LEN 1400
struct timeval timeout = {
  .tv_usec = 20000
};

record socketRecord[MAX_SOCKETS];
int sans_connect(const char* host, int port, int protocol) {
  char port_str[6];
  snprintf(port_str, sizeof(port_str), "%d", port);

  struct addrinfo hints, *res, *rp;
  int socketID = -1;

  memset(&hints, 0, sizeof(hints));
  if(protocol == IPPROTO_TCP)
  {
    hints.ai_family = AF_UNSPEC;
    hints.ai_socktype = SOCK_STREAM;
    hints.ai_flags = AI_PASSIVE;
    hints.ai_protocol = IPPROTO_TCP;
    int retreive = getaddrinfo(host, port_str, &hints, &res);
    if(retreive != 0){
      fprintf(stderr, "getaddrinfo error: %s\n", gai_strerror(retreive));
      return -1;
    }
    for(rp = res; rp != NULL; rp = rp->ai_next)
    {
      socketID = socket(rp->ai_family, rp->ai_socktype, rp->ai_protocol);
      if(socketID == -1) continue;

      if(connect(socketID, rp->ai_addr, rp->ai_addrlen) >= 0) break;

      socketID = -1;
  }
    return socketID;
  }
  //Function MUST check the protocol value
  else if(protocol == IPPROTO_RUDP)
  {
    hints.ai_family = AF_UNSPEC;
    //Function MUST create a SOCK_DGRAM socket using an IPPROTO_UDP protocol
    hints.ai_socktype = SOCK_DGRAM;
    hints.ai_flags = AI_PASSIVE;
    hints.ai_protocol = IPPROTO_UDP;

    rudp_packet_t send = {0};
    rudp_packet_t rec = {0};

    int retreive = getaddrinfo(host, port_str, &hints, &res);
    if(retreive != 0){
      fprintf(stderr, "getaddrinfo error: %s\n", gai_strerror(retreive));
      return -1;
    }

    for(rp = res; rp != NULL; rp = rp->ai_next)
    {
      socketID = socket(rp->ai_family, rp->ai_socktype, rp->ai_protocol);
      if(socketID != -1) break;
    }

    // Function MUST perform a 3-way handshake with the remote server
    send.type = SYN;
    sendto(socketID, &send, PKT_LEN, 0, rp->ai_addr, rp->ai_addrlen);
    setsockopt(socketID, SOL_SOCKET, SO_RCVTIMEO, &timeout, sizeof(timeout));

    socklen_t addrSize = sizeof(rp->ai_addrlen);

    while(1){
      if(recvfrom(socketID, &rec, sizeof(rec), 0, rp->ai_addr, &addrSize) == -1)
        sendto(socketID, &send, PKT_LEN, 0, rp->ai_addr, rp->ai_addrlen);
      else if(rec.type == (SYN | ACK)) break;
    }
    send.type = ACK;
    sendto(socketID, &send, PKT_LEN, 0, rp->ai_addr, rp->ai_addrlen);

    //Function MUST create a record of the connection that stores the address of the server
    record newEntry;
    newEntry.sock = socketID;
    newEntry.addr.ai_addr = rp->ai_addr;
    socketRecord[socketID] = newEntry;
    return socketID;
  }
  return 0;
}

int sans_accept(const char* addr, int port, int protocol) {
  // Convert the port integer to a string.
  char port_str[6];
  snprintf(port_str, sizeof(port_str), "%d", port);

  struct addrinfo hints, *res, *rp;
  int socketID = -1;

  memset(&hints, 0, sizeof(hints));
  

  if(protocol == IPPROTO_TCP){
    hints.ai_family = AF_UNSPEC;
    hints.ai_socktype = SOCK_STREAM;
    hints.ai_flags = AI_PASSIVE;
    hints.ai_protocol = IPPROTO_TCP;
    int retreive = getaddrinfo(addr, port_str, &hints, &res);
    if(retreive != 0) return -1;
    for (rp = res; rp != NULL; rp = rp->ai_next)
    {
      socketID = socket(rp->ai_family, rp->ai_socktype, rp->ai_protocol);
      if (socketID == -1) continue;

      if(bind(socketID, rp->ai_addr, rp->ai_addrlen) == 0 && listen(socketID,SOMAXCONN) == 0)
        break;
    }
    
    if(socketID == -1) return -1;

    int client_id = accept(socketID, NULL, NULL);
    if (client_id == -1) {
      close(socketID);  // Close the listening socket if accept fails
      return -1;
    }
    return client_id;
  }
  //Function MUST check the protocol value
  else if(protocol == IPPROTO_RUDP)
  {
    hints.ai_family = AF_UNSPEC;
    hints.ai_socktype = SOCK_DGRAM;
    hints.ai_flags = AI_PASSIVE;
    //Function MUST create a SOCK_DGRAM socket with an IPPROTO_UDP interface
    hints.ai_protocol = IPPROTO_UDP;
    int retreive = getaddrinfo(addr, port_str, &hints, &res);
    if(retreive != 0) return -1;

    for(rp = res; rp != NULL; rp = rp->ai_next)
    {
      socketID = socket(rp->ai_family, rp->ai_socktype, rp->ai_protocol);
      if(socketID != -1) break;
    }
    //Function MUST preform a 3-way handshake with the remote client
    rudp_packet_t rec = {0};
    rudp_packet_t send = {0};

    socklen_t addrSize = sizeof(rp->ai_addrlen);
    recvfrom(socketID, &rec, PKT_LEN, 0, rp->ai_addr, &addrSize);

    while(1){
      if(rec.type == SYN) break;
      recvfrom(socketID, &rec, PKT_LEN, 0, rp->ai_addr, &addrSize);
    }

    //Function MUST create a record of the connection that stores the address of the connecting client
    record newEntry;
    newEntry.sock = socketID;
    newEntry.addr.ai_addr = rp->ai_addr;
    socketRecord[socketID] = newEntry;

    send.type = SYN | ACK;
    sendto(socketID, &send, PKT_LEN, 0, rp->ai_addr, rp->ai_addrlen);
    setsockopt(socketID, SOL_SOCKET, SO_RCVTIMEO, &timeout, sizeof(timeout));

    while(1){
      if(recvfrom(socketID, &rec, PKT_LEN, 0, rp->ai_addr, &addrSize) == -1){
        send.type = SYN | ACK;
        sendto(socketID, &send, PKT_LEN, 0, rp->ai_addr, rp->ai_addrlen);
      }
      else break;
    }
    return socketID;
  }
  return 0;
}

int sans_disconnect(int socket) {
  return close(socket);
}
