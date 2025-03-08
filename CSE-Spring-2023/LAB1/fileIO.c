#define  _POSIX_C_SOURCE 200809L
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char* argv[])
{
	if(argc != 3)
	{
		printf("Must have filename and string as arguments\n");
		exit(EXIT_FAILURE);
	}
	
	int count = 0;
	FILE *fptr;
	char* line;
	size_t len = 0;
	fptr = fopen(argv[1], "r");
	if(fptr == NULL)
	{
		printf("Error opening file\n");
		exit(EXIT_FAILURE);
	}

	while(getline(&line,&len,fptr) != -1)
	{
		if(strstr(line,argv[2]) != NULL)
		{
			count = count + 1;
			
		}

	//	printf("%s",argv[2]);
	//	printf("line length: %zd\n", strlen(line));

	}

	fclose(fptr);
	printf("%d\n", count);
	exit(EXIT_SUCCESS);



}
