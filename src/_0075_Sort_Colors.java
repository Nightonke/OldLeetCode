
public class _0075_Sort_Colors {

/*	Given an array with n objects colored red, white or blue, sort them so that 
 *  objects of the same color are adjacent, with the colors in the order red, 
 *  white and blue.

	Here, we will use the integers 0, 1, and 2 to represent the color red, 
	white, and blue respectively.

	Note:
	You are not suppose to use the library's sort function for this problem.
*/	
	
	class Solution {
	public:
	    void sortColors(int A[], int n) {
	        int r, w, b;
	        r = w = b = 0;
	        for (int i = 0; i < n; i++) {
	            if (A[i] == 0) {
	                A[b++] = 2;
	                A[w++] = 1;
	                A[r++] = 0;
	            } else if (A[i] == 1) {
	                A[b++] = 2;
	                A[w++] = 1;
	            } else if (A[i] == 2) {
	                A[b++] = 2;
	            }
	        }
	    }
	};
	
}
