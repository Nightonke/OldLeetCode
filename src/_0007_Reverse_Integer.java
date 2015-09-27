
public class _0007_Reverse_Integer {

/*	Reverse digits of an integer.

	Example1: x = 123, return 321
	Example2: x = -123, return -321*/
	
	class Solution {
	public:
	    int reverse(int x) {
	        int positive = 1;
	        if (x < 0) {
	            positive = -1;
	            x = -x;
	        }
	        long long int ans = 0;
	        while (x) {
	            ans = ans * 10 + x % 10;
	            x /= 10;
	        }
	        return ans * positive;
	    }
	};

	
}
