
public class _0064_Minimum_Path_Sum {

/*	Given a m x n grid filled with non-negative numbers, find a path from top 
	left to bottom right which minimizes the sum of all numbers along its path.

	Note: You can only move either down or right at any point in time.*/
	
	class Solution {
	public:
	    int minPathSum(vector<vector<int> > &grid) {
	        vector<vector<int> > dp(grid.size());
	        for (int i = 0; i < dp.size(); i++) dp[i].resize(grid[i].size());
	        dp[0][0] = grid[0][0];
	        for (int i = 1; i < dp[0].size(); i++) {
	            dp[0][i] = dp[0][i - 1] + grid[0][i];
	        }
	        for (int i = 1; i < dp.size(); i++) {
	            dp[i][0] = dp[i - 1][0] + grid[i][0];
	        }
	        for (int i = 1; i < dp.size(); i++) {
	            for (int j = 1; j < dp[i].size(); j++) {
	                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
	            }
	        }
	        return dp[dp.size() - 1][dp[dp.size() - 1].size() - 1];
	    }
	};
	
}
