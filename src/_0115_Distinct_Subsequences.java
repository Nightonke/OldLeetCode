
public class _0115_Distinct_Subsequences {

/*	Given a string S and a string T, count the number of distinct subsequences 
 *  of T in S.

	A subsequence of a string is a new string which is formed from the original 
	string by deleting some (can be none) of the characters without disturbing 
	the relative positions of the remaining characters. (ie, "ACE" is a 
	subsequence of "ABCDE" while "AEC" is not).

	Here is an example:
	S = "rabbbit", T = "rabbit"

	Return 3.
	
	https://leetcode.com/discuss/26680/easy-to-understand-dp-in-java
	
	*/
	
	class Solution {
	public:
	    int numDistinct(string s, string t) {
	        int ans;
	        int ** dp;
	        dp = new int*[t.size() + 1];
	        for (int i = 0; i < t.size() + 1; i++) {
	            dp[i] = new int[s.size() + 1];
	        }

	        for (int i = 0; i < t.size() + 1; i++) {
	            dp[i][0] = 0;
	        }

	        for (int i = 0; i < s.size() + 1; i++) {
	            dp[0][i] = 1;
	        }

	        for (int i = 0; i < t.size(); i++) {
	            for (int j = 0; j < s.size(); j++) {
	                if (t[i] == s[j]) {
	                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j];
	                }
	                else {
	                    dp[i + 1][j + 1] = dp[i + 1][j];
	                }
	            }
	        }

	        ans = dp[t.size()][s.size()];

	        for (int i = 0; i < t.size() + 1; i++) {
	            delete[] dp[i];
	        }
	        delete[]dp;

	        return ans;
	    }
	};
	
}
