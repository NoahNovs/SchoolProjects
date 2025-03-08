#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char* argv[])
{
        if(argc != 3)
                exit(EXIT_FAILURE);
        int arr[2];
        pipe(arr);

        int x = fork();

        if (x < 0)
                exit(EXIT_FAILURE);

        //parent process
        if(!(x == 0))
        {
                //close reading
                close(arr[0]);

		char temp[200]= "/bin/";
		//check if path contains /bin/
		if(strstr(argv[1], temp) == 0)
		{
			strcat(temp,argv[1]);
			int n = strlen(temp) + 1;
                	if(write(arr[1], &n, sizeof(int)) < 0)
                        	exit(EXIT_FAILURE);
                	if(write(arr[1], temp, sizeof(char) * n) < 0)
                        	exit(EXIT_FAILURE);
		}
		else
		{
                	int n = strlen(argv[1]) + 1;
                	if(write(arr[1], &n, sizeof(int)) < 0)
                        	exit(EXIT_FAILURE);
                	if(write(arr[1], argv[1], sizeof(char) * n) < 0)
                        	exit(EXIT_FAILURE);
		}

		int m = strlen(argv[2]) + 1;
                if(write(arr[1], &m, sizeof(int)) < 0)
                        exit(EXIT_FAILURE);
                if(write(arr[1], argv[2], sizeof(char) * m) < 0)
                        exit(EXIT_FAILURE);
                close(arr[1]);
        }
        else if(x == 0)
	//child process
        {
                close(arr[1]);
                char str[200];
                int n;
                if(read(arr[0], &n, sizeof(int)) < 0)
                        exit(EXIT_FAILURE);
                if(read(arr[0], str, sizeof(char) * n) < 0)
                        exit(EXIT_FAILURE);

		char str2[200];
		int m;
		if(read(arr[0], &m, sizeof(int)) < 0)
                        exit(EXIT_FAILURE);
                if(read(arr[0], str2, sizeof(char) * m) < 0)
                        exit(EXIT_FAILURE);
		close(arr[0]);
		char *s;
		s = strchr(argv[2],'+');
		if(s !=  NULL){
			printf("1\n");
			execl(str,str,str2,NULL);
		}
		exit(2);

        }
	else
		exit(EXIT_FAILURE);
        exit(EXIT_SUCCESS);
}
