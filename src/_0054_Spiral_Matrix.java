
public class _0054_Spiral_Matrix {

/*	Given a matrix of m x n elements (m rows, n columns), return all elements 
 *  of the matrix in spiral order.

			For example,
			Given the following matrix:

			[
			 [ 1, 2, 3 ],
			 [ 4, 5, 6 ],
			 [ 7, 8, 9 ]
			]
			You should return [1,2,3,6,9,8,7,4,5].*/
	
	class Solution {
	public:
	    vector<int> spiralOrder(vector<vector<int> > &matrix) {
	        vector<int> ans;
	        if (matrix.empty()) return ans;
	        int wMin = 0, wMax = matrix[0].size() - 1;
	        int hMin = 0, hMax = matrix.size() - 1;
	        int si = 0, sj = 0;
	        int sum = matrix[0].size() * matrix.size();
	        int counter = 0;
	        while (counter < sum) {
	            for (; sj <= wMax && counter < sum; counter++) ans.push_back(matrix[si][sj++]);  // move right
	            si++, sj--, hMin++;
	            for (; si <= hMax && counter < sum; counter++) ans.push_back(matrix[si++][sj]);  // move down
	            si--, sj--, wMax--;
	            for (; sj >= wMin && counter < sum; counter++) ans.push_back(matrix[si][sj--]);  // move left
	            si--, sj++, hMax--;
	            for (; si >= hMin && counter < sum; counter++) ans.push_back(matrix[si--][sj]);  // move up
	            si++, sj++, wMin++;
	        }
	        return ans;
	    }
	};
	
}
