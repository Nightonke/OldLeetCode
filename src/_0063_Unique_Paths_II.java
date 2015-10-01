
public class _0063_Unique_Paths_II {

/*	Follow up for "Unique Paths":

	Now consider if some obstacles are added to the grids. How many unique paths 
	would there be?

	An obstacle and empty space is marked as 1 and 0 respectively in the grid.

	For example,
	There is one obstacle in the middle of a 3x3 grid as illustrated below.

	[
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
	]
	The total number of unique paths is 2.

	Note: m and n will be at most 100.*/
	
	class Solution {
	public:
	    int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid) {
	        vector<vector<int> > dp(obstacleGrid.size());
	        for (int i = 0 ; i < dp.size(); i++) dp[i].resize(obstacleGrid[i].size());
	        if (obstacleGrid[0][0] == 1) return 0;
	        else dp[0][0] = 1;
	        for (int i = 1; i < dp[0].size(); i++) {
	            if (obstacleGrid[0][i] == 1) dp[0][i] = 0;
	            else dp[0][i] = dp[0][i - 1];
	        }
	        for (int i = 1; i < dp.size(); i++) {
	            if (obstacleGrid[i][0] == 1) dp[i][0] = 0;
	            else dp[i][0] = dp[i - 1][0];
	        }
	        for (int i = 1; i < dp.size(); i++) {
	            for (int j = 1; j < dp[i].size(); j++) {
	                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
	                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
	            }
	        }
	        return dp[dp.size() - 1][dp[dp.size() - 1].size() - 1];
	    }
	};
	
}
