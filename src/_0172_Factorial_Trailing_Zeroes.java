
public class _0172_Factorial_Trailing_Zeroes {

/*	Given an integer n, return the number of trailing zeroes in n!.

	Note: Your solution should be in logarithmic time complexity.*/
	
	class Solution {
	public:
	    int trailingZeroes(int n) {
	        int sum = 0;
	        for (int i = n / 5; i; i /= 5) sum += i;
	        return sum;
	    }
	};
	
}
