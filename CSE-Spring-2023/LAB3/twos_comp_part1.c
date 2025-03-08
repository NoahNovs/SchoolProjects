#include <stdio.h>
#include <stdlib.h>

void bit_conversion(int x) {

      for(int i = 7; i >= 0; i--)
      {
              int num = x >> i;
              if(num & 1)
                      printf("1");
              else
                      printf("0");
      }
      printf("\n");
       // if (x > 1)
         //      bit_conversion(x >> 1);

   // printf("%d", x & 1);
}

int main(int argc, char *argv[])
{
	if(argc != 2)
		return 1;
	int x = atoi(argv[1]);

	if(x <= 127 && x >= -128)
	{
		bit_conversion(x);
		exit(EXIT_SUCCESS);
	}
	else
	{
		exit(EXIT_FAILURE);
	}
}


