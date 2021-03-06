
public class _0059_Spiral_Matrix_II {

/*	Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

	For example,
	Given n = 3,

	You should return the following matrix:
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]*/
	
	class Solution {
	public:
	    vector<vector<int> > generateMatrix(int n) {
	        vector<int> row(n, 0);
	        vector<vector<int> > ans(n, row);
	        int nowNum = 1, maxNum = n * n, i = 0, j = 0;
	        int dir[4][2] = {0, 1, 1, 0, 0, -1, -1, 0}, nowDir = 0;
	        while (nowNum <= n * n) {
	            if (i + dir[nowDir][0] < 0
	                || i + dir[nowDir][0] >= n
	                || j + dir[nowDir][1] < 0
	                || j + dir[nowDir][1] >= n
	                || ans[i + dir[nowDir][0]][j + dir[nowDir][1]] != 0) {
	                nowDir = (nowDir + 1) % 4;  // change the direction
	            }
	            ans[i][j] = nowNum++;
	            i += dir[nowDir][0];
	            j += dir[nowDir][1];
	        }
	        return ans;
	    }
	};
	
}
