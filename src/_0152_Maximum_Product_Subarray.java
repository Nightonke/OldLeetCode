
public class _0152_Maximum_Product_Subarray {

/*	Find the contiguous subarray within an array (containing at least one 
 *  number) which has the largest product.

	For example, given the array [2,3,-2,4],
	the contiguous subarray [2,3] has the largest product = 6.*/
	
	class Solution {
	public:
	    int maxProduct(int A[], int n) {
	        if (n == 1) return A[0];
	        int pMax = 0, nMax = 0, m = 0;
	        for (int i = 0; i < n; i++) {
	            if (A[i] < 0) swap(pMax, nMax);
	            pMax = max(pMax * A[i], A[i]);
	            nMax = min(nMax * A[i], A[i]);
	            m = max(m, pMax);
	        }
	        return m;
	    }
	};
	
}
