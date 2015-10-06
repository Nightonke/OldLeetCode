
public class _0140_Word_Break_II {

/*	Given a string s and a dictionary of words dict, add spaces in s to 
 *  construct a sentence where each word is a valid dictionary word.

	Return all such possible sentences.

	For example, given
	s = "catsanddog",
	dict = ["cat", "cats", "and", "sand", "dog"].

	A solution is ["cats and dog", "cat sand dog"].*/

	class Solution {
	public:

	    unordered_map<string, vector<string> > rem;

	    vector<string> wordBreak(string s, unordered_set<string>& wordDict) {
	        vector<string> ans;
	        if (rem.find(s) != rem.end()) {
	            return rem[s];
	        }
	        bool found = false;
	        for (int i = 0; i < s.size(); i++) {
	            if (wordDict.find(s.substr(i)) != wordDict.end()) {
	                found = true;
	                break;
	            }
	        }
	        if (!found) return ans;
	        if (wordDict.find(s) != wordDict.end()) {
	            ans.push_back(s);
	        }
	        for (int i = 1; i < s.size(); i++) {
	            string subs = s.substr(0, i);
	            if (wordDict.find(subs) != wordDict.end()) {
	                vector<string> partAns = wordBreak(s.substr(i), wordDict);
	                for (string ps : partAns) {
	                    ans.push_back(subs + " " + ps);
	                }
	            }
	        }
	        return ans;
	    }
	};
	
}
