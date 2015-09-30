
public class _0009_Palindrome_Number {

/*	Determine whether an integer is a palindrome. Do this without extra space.*/
	
	class Solution {
	public:
	    bool isPalindrome(int x) {
	        if (x < 0) return false;
	        long long int i, j = 10;
	        for (i = 10; x / i; i *= 10);
	        if (x == 0) i *= 10;
	        for (; j < i; i /= 10, j *= 10) {
	            if ((x % i) / (i / 10) != (x % j) / (j / 10)) return false;
	        }
	        return true;
	    }
	};
	
}
