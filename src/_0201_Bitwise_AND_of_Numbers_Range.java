
public class _0201_Bitwise_AND_of_Numbers_Range {

/*	Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND 
 *  of all numbers in this range, inclusive.

	For example, given the range [5, 7], you should return 4.*/
	
	int rangeBitwiseAnd(int m, int n) {
	    int base = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			base++;
		}
		return m << base;
	}
	
}