#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

void to_binary(int n, int i)
{
	//go until the amount of bits specified (i)
	int k;
	for (k = i - 1; k >= 0; k--) {
 
        	if ((n >> k) & 1)
		{
			//if(k == 0 && i == 23 && n % 2 == 1)
			//	printf("0");
			//else
				printf("1");
		}
//            		printf("1");
        	else
            		printf("0");
    }
}


typedef union
{
	float temp;
	struct
	{
		//found out that order matters
		//makes sense since LSB to MSB
	//	unsigned int sign : 1;
	//	unsigned int exp : 8;
	//	unsigned int mant : 23;
		unsigned int mant : 23;
		unsigned int exp : 8;
		unsigned int sign : 1;
	} field;
} myFloat;


int main(int argc, char *argv[])
{
	if(argc == 1)
	{
		printf("No input given\n");
		exit(EXIT_FAILURE);
	}
	if(argc != 2){
		//printf("Incorrect input argument\n");
		exit(EXIT_FAILURE);
	}

	//taken from hints
	double y = atof(argv[1]);

	//print the binary
	myFloat x;
	x.temp = (float) y;
	//printf("%d",x.field.sign);
	//printf("%d\n",x.field.mant);
	printf("%d",x.field.sign);
	to_binary(x.field.exp,8);
	to_binary(x.field.mant,23);
	printf("\n");
	exit(EXIT_SUCCESS);

}
