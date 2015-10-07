
public class _0231_Power_of_Two {

/*	Given an integer, write a function to determine if it is a power of two.*/
	
	class Solution {
	public:
	    bool isPowerOfTwo(int n) {
	        while (n) {
	            if (n % 2 == 1) {
	                return n == 1;
	            }
	            n /= 2;
	        }
	        return false;
	    }
	};
	
}
