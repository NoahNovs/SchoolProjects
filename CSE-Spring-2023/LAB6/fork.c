#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int SOME_INT;

int main (int argc, char *argv[])
{
	if(argc != 2)
		exit(EXIT_FAILURE);

	SOME_INT = atoi(argv[1]);
	int x = fork();
	printf("Hello World\n");
	if(x > 0)
		printf("Parent: %d\n", (SOME_INT+1));
	else if(x == 0)
		printf("Child: %d\n", (SOME_INT-1));
	exit(0);
}
