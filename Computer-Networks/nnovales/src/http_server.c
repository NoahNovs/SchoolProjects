#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "include/sans.h"
#include <netinet/in.h>
#include <sys/stat.h>
#define BUFFER_SIZE 1024


int http_server(const char* iface, int port) {

  char receive_buffer[BUFFER_SIZE];
  char send_buffer[BUFFER_SIZE];

  //Function MUST accept a connection from a remote client using sans_accept
  int socket = sans_accept(iface, port, IPPROTO_TCP);
  if(socket < 0)
  {
    fprintf(stderr, "Failed to connect to server.\n");
    return -1;
  }

  //Function MUST receive a request from the remote client using sans_recv_pkt
  int receive = sans_recv_pkt(socket, receive_buffer, BUFFER_SIZE);
  if(receive < 0)
  {
    printf("Error");
    sans_disconnect(socket);
    return -1;
  }

  //Function MUST send an HTTP response using sans_send_pkt

  char method[8], path[256], version[16];
  if(sscanf(receive_buffer, "%s %s %s", method, path, version) != 3){
    fprintf(stderr, "HTTP Request not valid\n");
    sans_disconnect(socket);
    return -1;
  }

  //only GET requests
  if(strncmp(method, "GET", 3) != 0)
  {
    fprintf(stderr, "Must be only GET Requests\n");
    sans_disconnect(socket);
    return -1;
  }

  struct stat file_stats;
  if(stat(path+1, &file_stats) != 0){
    snprintf(send_buffer, BUFFER_SIZE,
                 "HTTP/1.1 404 Not Found\r\n"
                 "Content-Length: 0\r\n"
                 "Content-Type: text/html; charset=utf-8\r\n"
                 "\r\n");
    sans_send_pkt(socket, send_buffer, strlen(send_buffer));
    sans_disconnect(socket);
    return -1;
  }

  FILE *file = fopen(path+1, "rb");
  if(!file){
    fprintf(stderr, "Cannot open file\n");
    sans_disconnect(socket);
    return -1;
  }

  long file_size = file_stats.st_size;

  snprintf(send_buffer, BUFFER_SIZE,
             "HTTP/1.1 200 OK\r\n"
             "Content-Length: %ld\r\n"
             "Content-Type: text/html; charset=utf-8\r\n"
             "\r\n", file_size);
  sans_send_pkt(socket, send_buffer, strlen(send_buffer));

  size_t bytes_read;
  while((bytes_read = fread(send_buffer, 1, BUFFER_SIZE, file)) > 0)
  {
    sans_send_pkt(socket, send_buffer, bytes_read);
  }
  fclose(file);
  sans_disconnect(socket);

  
  return 0;
}
