
public class _0131_Palindrome_Partitioning {

/*	Given a string s, partition s such that every substring of the partition is a palindrome.

	Return all possible palindrome partitioning of s.

	For example, given s = "aab",
	Return

	  [
	    ["aa","b"],
	    ["a","a","b"]
	  ]*/
	
	class Solution {
	public:
	    vector<vector<string> > partition(string inS) {
	        if (inS.empty()) return ans;
	        s = inS;
	        DFS(0);
	        return ans;
	    }
	    void DFS(int sp) {
	        if (sp == s.size()) {
	            ans.push_back(tryPalindrome);
	            return;
	        }
	        for (int i = sp; i < s.size(); i++) {
	            if (isPalindrome(sp, i)) {
	                tryPalindrome.push_back(s.substr(sp, i - sp + 1));
	                DFS(i + 1);
	                tryPalindrome.pop_back();
	            }
	        }
	    }
	    bool isPalindrome(int sp, int ep) {
	        for (int i = sp, j = ep; i < j; i++, j--) {
	            if (s[i] != s[j]) return false;
	        }
	        return true;
	    }
	    string s;
	    vector<vector<string> > ans;
	    vector<string> tryPalindrome;
	};
	
}
