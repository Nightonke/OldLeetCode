
public class _0139_Word_Break {

/*	Given a string s and a dictionary of words dict, determine if s can be 
 *  segmented into a space-separated sequence of one or more dictionary words.

	For example, given
	s = "leetcode",
	dict = ["leet", "code"].

	Return true because "leetcode" can be segmented as "leet code".*/
	
	class Solution {
	public:
	    bool wordBreak(string s, unordered_set<string> &dict) {
	        short isOK[s.size() + 1];
	        memset(isOK, 0, sizeof(isOK));
	        isOK[0] = 1;
	        for (int i = 1; i <= s.size(); i++) {
	            for (int j = 1; j <= i; j++) {
	                if (dict.find(s.substr(j - 1, i - j + 1)) != dict.end() && isOK[j - 1]) {
	                    isOK[i] = 1;
	                    break;
	                }
	            }
	        }
	        return isOK[s.size()];
	    }
	};
	
}
