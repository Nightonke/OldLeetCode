
public class _0097_Interleaving_String {

/*	Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

	For example,
	Given:
	s1 = "aabcc",
	s2 = "dbbca",

	When s3 = "aadbbcbcac", return true.
	When s3 = "aadbbbaccc", return false.*/
	
	class Solution {
	public:
	    bool isInterleave(string s1, string s2, string s3) {
	        if (s1.size() + s2.size() != s3.size()) return false;
	        vector<vector<bool> > dp(s1.size() + 1);
	        for (int i = 0; i < s1.size() + 1; i++) dp[i].resize(s2.size() + 1);
	        dp[0][0] = true;
	        for (int i = 1; i <= s2.size(); i++) {
	            if (dp[0][i - 1] && s2[i - 1] == s3[i - 1]) dp[0][i] = true;
	        }
	        for (int i = 1; i <= s1.size(); i++) {
	            if (dp[i - 1][0] && s1[i - 1] == s3[i - 1]) dp[i][0] = true;
	        }
	        for (int i = 1; i <= s1.size(); i++) {
	            for (int j = 1; j <= s2.size(); j++) {
	                if ((dp[i - 1][j] && s1[i - 1] == s3[i + j - 1]) || (dp[i][j - 1] && s2[j - 1] == s3[i + j - 1])) dp[i][j] = true;
	            }
	        }
	        return dp[s1.size()][s2.size()];
	    }
	};
	
}
