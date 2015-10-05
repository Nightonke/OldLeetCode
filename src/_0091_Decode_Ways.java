
public class _0091_Decode_Ways {

/*	A message containing letters from A-Z is being encoded to numbers using the 
 *  following mapping:

	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	Given an encoded message containing digits, determine the total number of 
	ways to decode it.

	For example,
	Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

	The number of ways decoding "12" is 2.*/

	class Solution {
	public:
	    inline bool is_letter(char front, char back) {
	        if (front >= '3' || front == '0') return false;
	        else if (front == '1') return true;
	        else if (back > '6') return false;
	        else return true;
	    }
	    int numDecodings(string s) {
	        if (s[0] == '0') return 0;
	        for (int i = 1; i < s.size(); i++) if (!is_letter(s[i - 1], s[i]) && s[i] == '0') return 0;
	        int ans[s.size() + 1];
	        for(int i = 0; i < s.size() + 1; ans[i++] = 0);
	        ans[0] = 1;
	        if (is_letter(s[0], s[1]) && s[1] != '0') ans[1] = 2;
	        else ans[1] = 1;
	        for (int i = 2; i < s.size(); i++)
	            if (s[i] == '0') ans[i] = ans[i - 2];
	            else if (is_letter(s[i - 1], s[i])) ans[i] = ans[i - 2] + ans[i - 1];
	            else ans[i] = ans[i - 1];
	        return ans[s.size() - 1];
	    }
	};
	
}
