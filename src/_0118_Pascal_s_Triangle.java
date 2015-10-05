
public class _0118_Pascal_s_Triangle {

/*	Given numRows, generate the first numRows of Pascal's triangle.

	For example, given numRows = 5,
	Return

	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]*/
	
	class Solution {
	public:
	    vector<vector<int> > generate(int numRows) {
	        vector<vector<int> > ans;
	        for (int i = 0; i < numRows; i++) {
	            vector<int> nowRow(1, 1);
	            for (int j = 0; j < i - 1; j++) {
	                nowRow.push_back(ans[i - 1][j] + ans[i - 1][j + 1]);
	            }
	            if (i > 0) nowRow.push_back(1);
	            ans.push_back(nowRow);
	        }
	        return ans;
	    }
	};
	
}
