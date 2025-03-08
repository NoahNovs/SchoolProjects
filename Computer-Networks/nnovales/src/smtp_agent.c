#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "include/sans.h"
#include <netinet/in.h>
#include <sys/stat.h>

char* read_email(const char* filepath){
  struct stat file_stat;
  if(stat(filepath, &file_stat) != 0)
  {
    fprintf(stderr, "Failed to stat file: %s\n", filepath);
    return NULL;
  }

  FILE* file = fopen(filepath, "r");
  if(file == NULL){
    fprintf(stderr, "Failed to open file\n");
    return NULL;
  }

  char* content = malloc(file_stat.st_size + 1);
  
  size_t read = fread(content, 1, file_stat.st_size, file);
  content[read] = '\0';

  fclose(file);
  return content;
}

int smtp_agent(const char* host, int port) {
  char send[256];
  char filepath[256];

  scanf("%255s", send);
  scanf("%255s", filepath);

  //connect to SMTP server
  int socket = sans_connect(host, port, IPPROTO_TCP);
  if(socket < 0)
  {
    fprintf(stderr, "Filed to connect to SMTP server\n");
    return -1;
  }

  char buffer[1024];

  sans_recv_pkt(socket, buffer, sizeof(buffer));

  //send HELO message
  snprintf(buffer, sizeof(buffer), "HELO localhost\r\n");
  sans_send_pkt(socket, buffer, strlen(buffer));
  sans_recv_pkt(socket, buffer, sizeof(buffer));
  if (strncmp(buffer, "250", 3) != 0) {
    fprintf(stderr, "Error: Expected 250 response, got: %s\n", buffer);
    sans_disconnect(socket);
    return -1;
  }

  //send MAIL FROM message
  snprintf(buffer, sizeof(buffer), "MAIL FROM: <%s>\r\n", send);
  sans_send_pkt(socket, buffer, strlen(buffer));
  sans_recv_pkt(socket, buffer, sizeof(buffer));
  if (strncmp(buffer, "250", 3) != 0) {
    fprintf(stderr, "Error: Expected 250 response, got: %s\n", buffer);
    sans_disconnect(socket);
    return -1;
  }

  //send RCPT TO message
  snprintf(buffer, sizeof(buffer), "RCPT TO: <%s>\r\n", send);
  sans_send_pkt(socket, buffer, strlen(buffer));
  sans_recv_pkt(socket, buffer, sizeof(buffer));
  if (strncmp(buffer, "250", 3) != 0) {
    fprintf(stderr, "Error: Expected 250 response, got: %s\n", buffer);
    sans_disconnect(socket);
    return -1;
  }

  //send DATA message to start the message body
  snprintf(buffer, sizeof(buffer), "DATA\r\n");
  sans_send_pkt(socket, buffer, strlen(buffer));
  sans_recv_pkt(socket, buffer, sizeof(buffer));
  if (strncmp(buffer, "354", 3) != 0) {
    fprintf(stderr, "Error: Expected 354 response, got: %s\n", buffer);
    sans_disconnect(socket);
    return -1;
  }

  //send contents of email file
  char* email_body = read_email(filepath);
  if(email_body == NULL)
  {
    fprintf(stderr, "Filed to read email file\n");
    return -1;
  }

  sans_send_pkt(socket, email_body, strlen(email_body));
  free(email_body);

  //Termination sequence
  snprintf(buffer, sizeof(buffer), "\r\n.\r\n");
  sans_send_pkt(socket, buffer, strlen(buffer));

  //receive final response
  sans_recv_pkt(socket, buffer, sizeof(buffer));
  printf("%s\n", buffer);

  //send QUIT message
  snprintf(buffer, sizeof(buffer), "QUIT\r\n");
  sans_send_pkt(socket, buffer, strlen(buffer));
  
  //receive quit
  sans_recv_pkt(socket, buffer, sizeof(buffer));

  sans_disconnect(socket);
  return 0;


}
