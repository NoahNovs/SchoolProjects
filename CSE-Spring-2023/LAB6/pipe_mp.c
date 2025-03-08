#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char* argv[])
{
        if(argc < 2)
                exit(EXIT_FAILURE);
        int arr[2];
        pipe(arr);

        int x = fork();

        if (x < 0)
                return 2;

        //child process
        if(x == 0)
        {
                //close reading
                close(arr[0]);

                int n = strlen(argv[1]) + 1;
                if(write(arr[1], &n, sizeof(int)) < 0)
                        return 4;
                if(write(arr[1], argv[1], sizeof(char) * n) < 0)
                        return 3;
                close(arr[1]);
        }
        else
        {
                close(arr[1]);
                char str[200];
                int n;
                if(read(arr[0], &n, sizeof(int)) < 0)
                        return 7;
                if(read(arr[0], str, sizeof(char) * n) < 0)
                        return 8;

                printf("%s\n", str);

                close(arr[0]);

        }
        exit(0);
}
