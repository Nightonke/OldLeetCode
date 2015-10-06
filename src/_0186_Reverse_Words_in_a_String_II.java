
public class _0186_Reverse_Words_in_a_String_II {

/*	Given an input string, reverse the string word by word. A word is defined as 
 *  a sequence of non-space characters.

	The input string does not contain leading or trailing spaces and the words 
	are always separated by a single space.

	For example,
	Given s = "the sky is blue",
	return "blue is sky the".

	Could you do it in-place without allocating extra space?

	Related problem: Rotate Array*/
	
	class Solution {
	public:
	    void reverseWords(string & s) {
	        reverseString(s, 0, s.size() - 1);
	        int i1 = 0, i2 = 0;
	        for (int i = 0; i < s.size(); i++) {
	            if (s[i] == ' ') {
	                i2 = i - 1;
	                reverseString(s, i1, i2);
	                i1 = i + 1;
	            }
	        }
	        i2 = s.size() - 1;
	        reverseString(s, i1, i2);
	    }
	    void reverseString(string & s, int i1, int i2) {
	        for (int i = (i1 + i2) / 2 + 1; i <= i2; i++) {
	            swap(s[i], s[i2 - i + i1]);
	        }
	    }
	};
	
}
