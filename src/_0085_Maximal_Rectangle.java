
public class _0085_Maximal_Rectangle {

/*	Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle 
	containing all ones and return its area.*/
	
	class Solution {
	public:
	    int maximalRectangle(vector<vector<char> > &matrix) {
	        if (matrix.size() == 0) return 0;
	        vector<int> height(matrix[0].size(), 0);
	        int tempArea, maxArea = 0;
	        for (int i = 0; i < matrix.size(); i++) {
	            int j;
	            for (j = 0; j < matrix[i].size(); j++) {
	                if (matrix[i][j] == '1') height[j]++;
	                else height[j] = 0;
	            }
	            stack<int> s;
	            for (j = 0; j < matrix[i].size();) {
	                if (s.empty() || height[s.top()] <= height[j]) {
	                    s.push(j++);
	                } else {
	                    int temp = s.top();
	                    s.pop();
	                    tempArea = height[temp] * (s.empty() ? j : j - s.top() - 1);
	                    maxArea = tempArea > maxArea ? tempArea : maxArea;
	                }
	            }
	            while (!s.empty()) {
	                int temp = s.top();
	                s.pop();
	                tempArea = height[temp] * (s.empty() ? j : j - s.top() - 1);
	                maxArea = tempArea > maxArea ? tempArea : maxArea;
	            }
	        }
	        return maxArea;
	    }
	};
	
}
