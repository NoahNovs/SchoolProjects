/* 
 * bitAnd - x&y using only ~ and | 
 *   Example: bitAnd(6, 5) = 4
 *   Legal ops: ~ |
 *   Points: 3
 */
int bitAnd(int x, int y) {
  return ~( ~x | ~y);
}

/* 
 * getByte - Extract nth byte from word x
 *   Bytes numbered from 0 (LSB) to 3 (MSB)
 *   Examples: getByte(0x12345678,1) = 0x56
 *   Legal ops: ! ~ & ^ | + - << >>
 *   Points: 6
 */
int getByte(int x, int n) {
  return (x >> (n << 3)) & 0xff;
}

/* 
 * byteSwap - swaps the nth byte and the mth byte
 *  Examples: byteSwap(0x12345678, 1, 3) = 0x56341278
 *            byteSwap(0xDEADBEEF, 0, 2) = 0xDEEFBEAD
 *  You may assume that 0 <= n <= 3, 0 <= m <= 3
 *  Legal ops: ! ~ & ^ | + - << >>
 *  Points: 6
 */
int byteSwap(int x, int n, int m) {
    int temp = 0;
    n = n << 3;
    m = m << 3;
    temp = 0xff & ((x >> n) ^ (x >> m));
    x = x ^ (temp << n);
    x = x ^ (temp << m);
    return x;
}

/* 
 * logicalShift - shift x to the right by n, using a logical shift
 *   Can assume that 0 <= n <= 31
 *   Examples: logicalShift(0x87654321,4) = 0x08765432
 *   Legal ops: ! ~ & ^ | + - << >>
 *   Points: 10
 */
int logicalShift(int x, int n) {
  return (x >> n) & (~((( 1 << 31) >> n) << 1));
}

/*
 * bitCount - returns count of number of 1's in word
 *   Examples: bitCount(5) = 2, bitCount(7) = 3
 *   Legal ops: ! ~ & ^ | + - << >>
 *   Points: 15
 */
int bitCount(int x) {
	//2 bytes not so significant
  int mask1 = 0x11 | (0x11 << 8);
  //everything else
  int mask2 = mask1 | (mask1 << 16);


  //keep adding in first 4 bits
  int sum = x & mask2;
  sum += (x >> 1) & mask2;
  sum += (x >> 2) & mask2;
  sum += (x >> 3) & mask2;
  //overestimate
  sum += (sum >> 16);

  mask1 = 0xF | (0xF << 8);

  //adds alternating 4 bits
  sum = (sum & mask1) + ((sum >> 4) & mask1);
  return ((sum + (sum >> 8)) & 0x3F);
}

/* 
 * bang - Compute !x without using !
 *   Examples: bang(3) = 0, bang(0) = 1
 *   Legal ops: ~ & ^ | + - << >>
 *   Points: 15
 */
int bang(int x) {
  return ((x >> 31) | ((~x + 1) >> 31)) + 1;
}

/*
 * bitParity - returns 1 if x contains an odd number of 1's
 *   Examples: bitParity(5) = 0, bitParity(7) = 1
 *   Legal ops: ! ~ & ^ | + - << >>
 *   Points: 15
 */
int bitParity(int x) {

	//from 32 bits, divide by 2
	int par16 = x ^ (x >> 16);
	int par8 = par16 ^ (par16 >> 8);
	int par4 = par8 ^ (par8 >> 4);
	int par2 = par4 ^ (par4 >> 2);
	int par = par2 ^ (par2 >> 1);
	return par & 0x01;
}
