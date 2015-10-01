
public class _0029_Divide_Two_Integers {

/*	Divide two integers without using multiplication, division and mod operator.

	If it is overflow, return MAX_INT.*/
	
	class Solution {
	public:
	    int divide(long long int dividend, long long int divisor) {
	        long long int positive = 1;
	        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
	            positive = -1;
	        }
	        if (dividend < 0) dividend = -dividend;
	        if (divisor < 0) divisor = -divisor;
	        long long int r = 0;
	        long long int c = divisor;
	        while (dividend > c) {
	            c <<= 1;
	        }
	        while (c >= divisor) {
	            r <<= 1;
	            if (dividend >= c) {
	                r++;
	                dividend -= c;
	            }
	            c >>= 1;
	        }
	        return r * positive;
	    }
	};
	
}
