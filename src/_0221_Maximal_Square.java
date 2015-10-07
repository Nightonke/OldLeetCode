
public class _0221_Maximal_Square {

/*	Given a 2D binary matrix filled with 0's and 1's, find the largest square 
 *  containing all 1's and return its area.

	For example, given the following matrix:

	1 0 1 0 0
	1 0 1 1 1
	1 1 1 1 1
	1 0 0 1 0
	Return 4.*/
	
	#define MIN(i, j) (i < j ? i : j)

	int maximalSquare(char** matrix, int matrixRowSize, int matrixColSize) {
	    if (matrixRowSize == 0) return 0;
	    int **dp = (int**)malloc(sizeof(int*) * matrixRowSize);
	    int ans = 0;
	    for (int i = 0; i < matrixRowSize; i++) dp[i] = (int*)malloc(sizeof(int) * matrixColSize);
	    for (int i = 0; i < matrixRowSize; i++) {
	        dp[i][0] = (matrix[i][0] & 1);
	        if (ans < dp[i][0]) ans = dp[i][0];
	    }
	    for (int i = 0; i < matrixColSize; i++) {
	        dp[0][i] = (matrix[0][i] & 1);
	        if (ans < dp[0][i]) ans = dp[0][i];
	    }
	    for (int i = 1; i < matrixRowSize; i++) {
	        for (int j = 1; j < matrixColSize; j++) {
	            if (matrix[i][j] & 1) dp[i][j] = MIN(dp[i - 1][j - 1], MIN(dp[i - 1][j], dp[i][j - 1])) + 1;
	            else dp[i][j] = 0;
	            if (ans < dp[i][j]) ans = dp[i][j];
	        }
	        free(dp[i - 1]);
	    }
	    free(dp[matrixRowSize - 1]);
	    free(dp);
	    return ans * ans;
	}
	
}
