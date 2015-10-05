
public class _0084_Largest_Rectangle_in_Histogram {

/*	Given n non-negative integers representing the histogram's bar height where 
 *  the width of each bar is 1, find the area of largest rectangle in the 
 *  histogram.


	Above is a histogram where width of each bar is 1, given height = 
	[2,1,5,6,2,3].


	The largest rectangle is shown in the shaded area, which has area = 10 unit.

	For example,
	Given height = [2,1,5,6,2,3],
	return 10.
	
	http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
	
	example: 2,1,5,6,2,3
	
	i h leftIndex w max ans indexs
	0                   0   0
	1 2 -1        1 2   2   1
	2                   2   1 2
	3                   2   1 2 3
	4 6 2         1 6   6   1 2
	4 5 1         2 10  10  1 4
	5                   10  1 4 5
	6 3 4         1 3   10  1 4
	6 2 1         4 8   10  1
	6 1 -1        6 6   10  
	
	notice that 2 6 10 3 8 6 are the possible answers.
	*/
	
	class Solution {
	public:
	    int largestRectangleArea(vector<int>& height) {
	        stack<int> indexs;
	        int ans = 0;
	        height.push_back(0);
	        for (int i = 0; i < height.size(); i++) {
	            while (!indexs.empty() && height[indexs.top()] >= height[i]) {
	                int h = height[indexs.top()];
	                indexs.pop();
	                int leftIndex = indexs.empty() ? -1 : indexs.top();
	                ans = max(ans, h * (i - leftIndex - 1));
	            }
	            indexs.push(i);
	        }
	        return ans;
	    }
	};
	
}
