
public class _0066_Plus_One {

/*	Given a non-negative number represented as an array of digits, plus one to 
	the number.

	The digits are stored such that the most significant digit is at the head of 
	the list.*/
	
	class Solution {
	public:
	    vector<int> plusOne(vector<int> &digits) {
	        digits.insert(digits.begin(), 0);
	        digits[digits.size() - 1] ++;
	        for (int i = digits.size() - 1; i > 0; i--) {
	            digits[i - 1] += digits[i] / 10;
	            digits[i] %= 10;
	        }
	        if (digits[0] == 0) {
	            digits.erase(digits.begin());
	        }
	        return digits;
	    }
	};

	
}
