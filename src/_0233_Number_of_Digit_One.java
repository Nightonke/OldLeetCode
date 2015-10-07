
public class _0233_Number_of_Digit_One {

/*	Given an integer n, count the total number of digit 1 appearing in all 
 *  non-negative integers less than or equal to n.

	For example:
	Given n = 13,
	Return 6, because digit 1 occurred in the following numbers: 
	1, 10, 11, 12, 13.

	Hint:

	Beware of overflow.*/

	class Solution {
	public:
	    int countDigitOne(int n) {
	        int ans = 0;
	        for (long m = 1; m <= n; m *= 10) {
	            ans += (n / m + 8) / 10 * m + (n / m % 10 == 1) * (n % m + 1);
	        }
	        return ans;
	    }
	};
	
}
