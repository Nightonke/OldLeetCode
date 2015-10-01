
public class _0043_Multiply_Strings {

/*	Given two numbers represented as strings, return multiplication of the 
 *  numbers as a string.

			Note: The numbers can be arbitrarily large and are non-negative.*/
	
	class Solution {
	public:
	    string multiply(string num1, string num2) {
	        string ans(num1.length() + num2.length() + 1, 0);
	        reverse(num1.begin(), num1.end());
	        reverse(num2.begin(), num2.end());
	        for (int i = 0; i < num1.size(); i++) num1[i] -= '0';
	        for (int i = 0; i < num2.size(); i++) num2[i] -= '0';
	        for (int i = 0; i < num1.length(); i++) {
	            for (int j = 0; j < num2.length(); j++) {
	                ans[i + j] += num1[i] * num2[j];
	                ans[i + j + 1] += ans[i + j] / 10;
	                ans[i + j] %= 10;
	            }
	        }
	        int i;
	        for (i = num1.length() + num2.length(); i > 0 && ans[i] == 0; i--);
	        ans = ans.substr(0, i + 1);
	        reverse(ans.begin(), ans.end());
	        for (int i = 0; i < ans.size(); i++) ans[i] += '0';
	        return ans;
	    }
	};
	
}
