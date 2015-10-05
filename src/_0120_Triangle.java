
public class _0120_Triangle {

/*	Given a triangle, find the minimum path sum from top to bottom. Each step 
 *  you may move to adjacent numbers on the row below.

	For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

	Note:
	Bonus point if you are able to do this using only O(n) extra space, where n 
	is the total number of rows in the triangle.*/
	
	class Solution {
	public:
	    int minimumTotal(vector<vector<int> > &triangle) {
	        if (triangle.size() == 0) return 0;
	        vector<int> ans(2, -1);
	        vector<int> lastAns;
	        lastAns.push_back(triangle[0][0]);
	        for (int i = 1; i < triangle.size(); i++) {
	            vector<int> partOfAns(i + 1, -1);
	            for (int j = 0; j < triangle[i].size(); j++) {
	                if (j == 0) {
	                    ans[j] = lastAns[j] + triangle[i][j];
	                } else if (j == triangle[i].size() - 1) {
	                    ans[j] = lastAns[j - 1] + triangle[i][j];
	                } else {
	                    ans[j] = (lastAns[j - 1] < lastAns[j] ? lastAns[j - 1] : lastAns[j]) + triangle[i][j];
	                }
	            }
	            lastAns = ans;
	            ans.push_back(-1);
	        }
	        int min = lastAns[0];
	        for (int i = 0 ;i < lastAns.size(); i++) {
	            if (min > lastAns[i]) min = lastAns[i];
	        }
	        return min;
	    }
	};
	
}
