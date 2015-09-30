
public class _0014_Longest_Common_Prefix {

/*	Write a function to find the longest common prefix string amongst an array 
 * of strings.*/
	
	class Solution {
	public:
	    string longestCommonPrefix(vector<string> &strs) {
	        if (strs.size() == 0) return "";
	        string prefix;
	        int pos = 0;
	        char commonChar;
	        while (1) {
	            commonChar = strs[0][pos];
	            if (commonChar == '\0') return prefix;
	            for (int i = 1; i < strs.size(); i++) {
	                if (strs[i][pos] != commonChar) return prefix;
	            }
	            prefix.push_back(commonChar);
	            pos++;
	        }
	    }
	};
}
