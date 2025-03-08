#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char* argv[])
{
	if(argc != 3)
		exit(EXIT_FAILURE);
	char temp[] = "/bin/";
	strcat(temp,argv[1]);
	execl(temp, temp,argv[2], NULL);
        exit(0);
}
