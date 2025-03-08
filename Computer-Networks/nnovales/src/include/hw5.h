#include <netinet/in.h>
#include <sys/types.h>
#include <sys/socket.h>

#define SOCKET_SIZE 10
typedef struct {
  int sock;                   // Socket ID
  int seqnum;
  struct addrinfo addr;
} record;

extern record socketRecord[SOCKET_SIZE];