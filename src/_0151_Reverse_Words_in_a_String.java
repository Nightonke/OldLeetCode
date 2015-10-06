
public class _0151_Reverse_Words_in_a_String {

/*	Given an input string, reverse the string word by word.

	For example,
	Given s = "the sky is blue",
	return "blue is sky the".

	Update (2015-02-12):
	For C programmers: Try to solve it in-place in O(1) space.*/
	
	class Solution {
	public:
	    void reverseWords(string &s) {
	        bool first = true;
	        string temp = " ";
	        temp += s + " ";
	        s.clear();
	        for (int i = temp.size() - 1; i > 0;) {
	            if (temp[i] == ' ' && temp[i - 1] != ' ') {
	                int j;
	                for (j = i - 1; j > 0; j--) {
	                    if (temp[j] != ' ' && temp[j - 1] == ' ') {
	                        if (!first) {
	                            s += " ";
	                        }
	                        first = false;
	                        s += temp.substr(j, i - j);
	                        break;
	                    }
	                }
	                i = j - 1;
	            } else {
	                i--;
	            }
	        }
	    }
	};

	
}
