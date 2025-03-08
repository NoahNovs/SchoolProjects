#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <stdio.h>

int is_binary(const char * in)
{
	if(!in || !*in)
		return 0;
	return in[strspn(in,"01")] == '\0';
}

//unsigned int convertToInt(char* arr, int low, int high)
//{
//    unsigned f = 0;
//    int i;
//    for (i = high; i >= low; i--) {
//        f += arr[i] * pow(2.0, high - i);
//    }
//    return f;
//}


int to_int(char* arr)
{
	int bin, dec = 0;
	bin = atoi(arr);
	for(int i = 0; bin; i++, bin /= 10)
	{
		if(bin % 10)
		{
			dec += pow(2, i);
		}
	}
	return dec;
}

double to_double(char* arr)
{
	int someArr[24];
	for(int i = 0; i < 23; i++)
	{
		if(arr[i] == '1')
			someArr[i] = 1;
		else
			someArr[i] = 0;
		//printf("%d",someArr[i]);
	}
	
	double dec = 0.0;

	for(int i = 22; i >= 0; i--)
	{
		if(someArr[i] == 1)
			dec += pow(2,-(i+1));
	}

        //for(int i = 1; bin; i++, bin /= 10)
        //{
          //      if(bin % 10)
            //    {
	//		dec+= pow(2,(i*-1));
	//		//printf("%d\n",i);
          //      }
	//}
        return dec;
}

int main(int argc, char *argv[])
{
	if(argc != 2)
		exit(EXIT_FAILURE);
	if(is_binary(argv[1]) == 0)
	{
		printf("Incorrect input argument\n");
		exit(EXIT_FAILURE);
	}

	char sign = argv[1][0];
	//printf("%d", sign);
	char exponent[9];

	memset(exponent, '\0', sizeof(exponent));
	strncpy(exponent, &argv[1][1], 8);
	exponent[8] = '\0';

	char mantissa[24];
	memcpy(mantissa, &argv[1][9],23);
	mantissa[23] = '\0';
	int exp = to_int(exponent);
	//printf("%s\n", mantissa);
	
	int isNormal = 1;
	double mant;
 	if(exp != 0 && exp < 255)	
		mant = to_double(mantissa)+1;
	else{
		mant = to_double(mantissa);
		isNormal = 0;
	}

	double num;
	if(sign == '1'){
		if(isNormal)
			num = -1 * (mant * pow(2,(exp-127)));
		else
			num = -1 * (mant * pow(2,(exp-126)));
	}
	else{
		if(isNormal)
			num = (mant * pow(2,(exp-127)));
		else
			num = (mant * pow(2,(exp-126)));
	}
	printf("Sign: %c\n", sign);
	printf("Exponent: %d\n",exp);
	printf("Mantissa: %.17g\n",mant);
	printf("Number: %.7g\n",num);
	exit(EXIT_SUCCESS);
}
