#define  _POSIX_C_SOURCE 200809L
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <unistd.h>

int first_file_count(const char *file, const char *word)
{
	time_t begin = time(NULL);

    	// do some stuff here

        FILE *fptr;
        char* line;
        int count = 0;
        size_t len = 0;
        fptr = fopen(file,"r");
        if(fptr == NULL)
        {
                printf("Error opening file\n");
                exit(EXIT_FAILURE);
        }

	
        while(getline(&line,&len,fptr) != -1)
        {
		const char *temp = line;
  		while((temp = strstr(temp, word)))
                {
                        count = count + 1;
			temp = temp + 1;

                }

        }

        fclose(fptr);
	time_t end = time(NULL);
	fptr = fopen("README.md", "a");
	if(fptr == NULL)
        {
                printf("Error opening file\n");
                exit(EXIT_FAILURE);
        }
	fprintf(fptr, "%ld miliseconds\n", (end-begin)*1000);
        return count;
//        printf("%d\n", count);
}



int main(int argc, char* argv[])
{
        if(argc != 5)
        {
                printf("Must have filename and string as arguments\n");
                exit(EXIT_FAILURE);
        }
	int football = first_file_count(argv[1], argv[2]);
	printf("football Count: %d\n", football);

	int user = first_file_count(argv[3],argv[4]);
	printf("username Count: %d\n", user);

	exit(EXIT_SUCCESS);
}
