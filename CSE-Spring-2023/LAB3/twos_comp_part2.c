#include <stdio.h>
#include <stdlib.h>
#include <string.h>

unsigned int binary_to_uint(const char *b)
{
  unsigned int val = 0;
  int i = 0;

  //if no other digit
  if (b == NULL)
    return 0;

  //while there is a binary string
  while (b[i] == '0' || b[i] == '1')
  {
    val <<= 1;
    //go thru char *b
    val += b[i]-'0';
    i++;
  }
  return val;
}



int main(int argc, char *argv[])
{
	if(argc != 3)
		exit(EXIT_FAILURE);

	if(strcmp("signed", argv[2]) == 0)
	{
		if(strlen(argv[1]) <= 8)
                {
                        int x = binary_to_uint(argv[1]);
			int y = 0;
			if(x >= 0 && x <= 127)
				y = x;
			else
				y = x - 256;
			if(y >= -128 && y <= 127)
			{
			       	printf("%d\n",y);
                	        exit(EXIT_SUCCESS);
			}
			else
				exit(EXIT_FAILURE);
                }
		else
			exit(EXIT_FAILURE);
	}
	else if(strcmp("unsigned", argv[2]) == 0)
	{
		if(strlen(argv[1]) <= 8)
		{
			int x = binary_to_uint(argv[1]);
			if(x > -1 && x <= 255)
			{
				printf("%d\n",x);
				exit(EXIT_SUCCESS);
			}
			else
				exit(EXIT_FAILURE);
		}
		else
			exit(EXIT_FAILURE);
	}
	else
		exit(EXIT_FAILURE);
}
