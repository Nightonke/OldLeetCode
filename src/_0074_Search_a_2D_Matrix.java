
public class _0074_Search_a_2D_Matrix {

/*	Write an efficient algorithm that searches for a value in an m x n matrix. 
 *  This matrix has the following properties:

		Integers in each row are sorted from left to right.
		The first integer of each row is greater than the last integer of the 
		previous row.
		For example,

		Consider the following matrix:

		[
		  [1,   3,  5,  7],
		  [10, 11, 16, 20],
		  [23, 30, 34, 50]
		]
		Given target = 3, return true.*/
	
	class Solution {
	public:
	    bool searchMatrix(vector<vector<int> > &matrix, int target) {
	        if (matrix.empty() || matrix[0][0] > target || matrix[matrix.size() - 1][matrix[matrix.size() - 1].size() - 1] < target) return false;
	        int findI = 0, findJ = matrix[0].size() - 1;
	        while (findI < matrix.size() && findJ >= 0) {
	            if (target < matrix[findI][findJ]) findJ--;
	            else if (target > matrix[findI][findJ]) findI++;
	            else return true;
	        }
	        return false;
	    }
	};
	
}
