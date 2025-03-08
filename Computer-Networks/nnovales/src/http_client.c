#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "include/sans.h"
#include <netinet/in.h>

//All packets MUST be 1024 bytes or less (maximum buffer size)
#define BUFFER_SIZE 1024

int http_client(const char* host, int port) {
  //Function MUST prompt the user for two values

  //The first value MUST be read as the method of the request
  //(for this project, only GET is required)

  char method[50];
  //The second value MUST be read as the path of the request
  char path[BUFFER_SIZE];
  char request[BUFFER_SIZE];
  char response[BUFFER_SIZE];

  // Function MUST receive response from the server using the provided sans_recv_pkt
  int received = 0;
  int total_received = 0;
  int content_length = -1;
  int headers_received = 0;
  int header_size = 0;

  scanf("%s %s", method, path);
  //path MUST NOT include the leading / character when read from the user
  if (strncmp(path, "/", 1) == 0)
  {
    size_t len = strlen(path);
    for(size_t i = 0; i < len; i++)
    {
      path[i] = path[i+1];
    }
  }

  if (strcmp(method, "GET") != 0)
  {
    printf("Must be GET request\n");
    return -1;
  }

  int sock = sans_connect(host, port, IPPROTO_TCP);
  if(sock < 0)
  {
    printf("Failed to connect to server.\n");
    return -1;
  }

  //Function MUST send a valid HTTP request using the sans_send_pkt
  int request_len = snprintf(request, sizeof(request),
                               "GET /%s HTTP/1.1\r\n"
                               "Host: %s:%d\r\n"
                               "User-Agent: sans/1.0\r\n"
                               "Cache-Control: no-cache\r\n"
                               "Connection: close\r\n"
                               "Accept: */*\r\n"
                               "\r\n",
                               path, host, port);
    
    if (request_len < 0) {
        printf("Failed to construct request.\n");
        sans_disconnect(sock);
        return -1;
    }

    // Split and send the request in multiple packets if necessary
    int total_sent = 0;
    while (total_sent < request_len) {
        int bytes_to_send = request_len - total_sent > BUFFER_SIZE ? BUFFER_SIZE : request_len - total_sent;
        int sent = sans_send_pkt(sock, request + total_sent, bytes_to_send);
        if (sent < 0) {
            printf("Failed to send request to server.\n");
            sans_disconnect(sock);
            return -1;
        }
        total_sent += sent;
    }

  while ((received = sans_recv_pkt(sock, response, sizeof(response) - 1)) > 0) {
      response[received] = '\0';
      printf("%s", response);     // Print received data
      
    // If we haven't parsed headers yet, check for Content-Length
    if (!headers_received) 
    {
      // Manually search for the end of headers since strstr cannot be used (\r\n\r\n)
      for (int i = 0; i < received - 3; i++) {
        if (response[i] == '\r' && response[i + 1] == '\n' &&
            response[i + 2] == '\r' && response[i + 3] == '\n') {
          headers_received = 1;
          header_size = i + 4;  // End of headers
          break;
        }
      }

      // If headers received, manually find the "Content-Length: " header
      for (int i = 0; i < header_size - 16; i++) {
        if (strncmp(&response[i], "Content-Length: ", 16) == 0) {
          content_length = strtol(&response[i + 16], NULL, 10);
          break;
        }
      }

      // Adjust total received to account for body data that might have been received
      total_received = received - header_size;
    } 
    else 
    {
      total_received += received;  // Add to total body size received
    }

      // If content length is known and we've received all the data, stop reading
      if (content_length != -1 && total_received >= content_length) 
      {
          break;
      }
  }
  
  if (received < 0) 
  {
      printf("Failed to receive data from server.\n");
  }
  
  // Disconnect from the server
  sans_disconnect(sock);
  return 0;
}
