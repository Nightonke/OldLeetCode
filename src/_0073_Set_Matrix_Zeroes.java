
public class _0073_Set_Matrix_Zeroes {

/*	Given a m x n matrix, if an element is 0, set its entire row and column to 
 *  0. Do it in place.*/
	
	class Solution {
	public:
	    void setZeroes(vector<vector<int> > &matrix) {
	        for (int i = 0; i < matrix.size(); i++) {
	            for (int j = 0; j < matrix[i].size(); j++) {
	                if (!matrix[i][j]) {
	                    for (int ii = 0; ii < matrix.size(); ii++) {
	                        if (matrix[ii][j]) matrix[ii][j] = 13331091;
	                    }
	                    for (int jj = 0; jj < matrix[i].size(); jj++) {
	                        if (matrix[i][jj]) matrix[i][jj] = 13331091;
	                    }
	                }
	            }
	        }
	        for (int i = 0; i < matrix.size(); i++) {
	            for (int j = 0; j < matrix[i].size(); j++) {
	                if (matrix[i][j] == 13331091) matrix[i][j] = 0;
	            }
	        }
	    }
	};
}
