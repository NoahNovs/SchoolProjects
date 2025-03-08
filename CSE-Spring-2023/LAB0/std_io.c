#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main (int argc, char* argv[]) {
	if(argc == 2)
	{
		if(strcmp(argv[1],"scanf") == 0)
		{
                	char in[20];
                	printf("Please enter your input: ");
                	scanf("%s", in);
                	printf("You entered: %s\n", in);
		}
		else
		{
			printf("Error: Incorrect Argument\n");
			exit(EXIT_FAILURE);
		}
	}
	else if (argc == 3)
	{
		if(strcmp(argv[1], "printf") == 0)
		{
			printf("You entered: %s\n",  argv[2]);
                	exit(EXIT_SUCCESS);
		}
		else if(strcmp("fprintf", argv[1]) == 0)
		{
			FILE *fptr = fopen("print.txt", "w");
                	if(fptr == NULL)
                	{
                        	printf("Could not open file");
                       		 exit(EXIT_FAILURE);
                	}

                	fprintf(fptr,"%s\n", argv[2]);

                	fclose(fptr);
                	exit(EXIT_SUCCESS);
		}
		else
		{
			printf("Error: Arguments not valid\n");
			exit(EXIT_FAILURE);
		}
	}
	else
	{
		printf("Error: Number of arguments not valid\n");
		exit(EXIT_FAILURE);
	}
}
