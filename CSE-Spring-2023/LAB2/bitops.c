#include "bitops.h"
#include <stdio.h>

/*
 * Return and of x and y
 * Points: 3
 */
int and_op(int x, int y) {
  
	return (x&y);
}

/* 
 * Return or of x and y
 * Points: 3
 */
int or_op(int x, int y) {
  return (x|y);
}

/*
 * Return xor of x and y
 * Points: 3
 */
int xor_op(int x, int y) {
  return (x^y);
}


/*
 * Clear `b`th byte of x
 * Points: 7
 */
int masking_and(int x, int b) {
	for(int i = 8*(b+1)-1; i >(8*(b+1)) - 9; i--)
	{
		x &= ~(1 << i);
	}
	return x;
}

/*
 * Set `b`th byte of x
 * Points: 7
 */
int masking_or(int x, int b) {
	for(int i = 8*(b+1)-1; i >(8*(b+1)) - 9; i--)
        {
                x |= 1 << i;
        }
        return x;
}

/*
 * Toggle `b`th byte of x
 * Points: 7
 */
int masking_xor(int x, int b) {
 
	for(int i = 8*(b+1)-1; i >(8*(b+1)) - 9; i--)
        {
                x ^= 1 << i;
        }
        return x;
}

/*
 * Shift x to the left by `sc` # of bits
 * Points: 3
 */
int shifting_left_op(int x, int sc) {
  return (x << sc);
}

/*
 * Shift x to the right by `sc` # of bits
 * Points: 3
 */
int shifting_right_op(int x, int sc) {
  return (x >> sc);
}


/*
 * Return logical not of x
 * Points: 3
 */
int bang(int x) {
  return !x;
}

/*
 * Print binary string representation for x
 * Points: 30
 */
void bit_conversion(int x) {

//	for(int i = ; i >= 0; i--)
//	{
//		int num = x >> i;
//		if(num & 1)
//			printf("1");
//		else
//			printf("0");
//	}
//	printf("\n");
	if (x > 1)
 	       bit_conversion(x >> 1);
 
    printf("%d", x & 1);
}
