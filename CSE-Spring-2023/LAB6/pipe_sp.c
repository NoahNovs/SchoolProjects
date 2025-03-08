#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char* argv[])
{
	if(argc < 3)
		exit(EXIT_FAILURE);
	int arr[2];
	pipe(arr);
	char str[200];
	char str2[200];
	
	write(arr[1], argv[1], strlen(argv[1]) + 1);
	write(arr[1], argv[2], strlen(argv[2]) + 1);


	if(read(arr[0], str, strlen(argv[1]) + 1) < 0)
                {
                        exit(EXIT_FAILURE);
                }
	if(read(arr[0], str2, strlen(argv[2]) + 1) < 0)
                {
                        exit(EXIT_FAILURE);
                }
	printf("%s\n", str);
	printf("%s\n", str2);
	exit(0);
}
