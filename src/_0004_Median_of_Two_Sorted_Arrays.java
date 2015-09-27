
public class _0004_Median_of_Two_Sorted_Arrays {

	/*There are two sorted arrays nums1 and nums2 of size m and n respectively. 
	 * Find the median of the two sorted arrays. The overall run time complexity 
	 * should be O(log (m+n)).*/
	
	class Solution {
	public:
	    double findMedianSortedArrays(int A[], int m, int B[], int n) {
	        if ((m + n) & 1)  // (m + n) is odd
	            return findKthSmallest(A, m, B, n, (m + n) / 2 + 1);
	        else
	            return (findKthSmallest(A, m, B, n, (m + n) / 2) + findKthSmallest(A, m, B, n, (m + n) / 2 + 1)) / 2.0;
	    }
	    int findKthSmallest(int A[], int m, int B[], int n, int k) {
	        int i = (int)((double)m / (m + n) * (k - 1));
	        int j = (k - 1) - i;

	        // Note: A[-1] = -INF and A[m] = +INF to maintain invariant
	        int Ai_1 = ((i == 0) ? INT_MIN : A[i-1]);  // when i == 0, A[i - 1] is INT_MIN
	        int Bj_1 = ((j == 0) ? INT_MIN : B[j-1]);  // when j == 0, B[j - 1] is INT_MIN
	        int Ai   = ((i == m) ? INT_MAX : A[i]);    // when i == m, A[i] is INT_MAX
	        int Bj   = ((j == n) ? INT_MAX : B[j]);    // when j == n, B[j] is INT_MAX

	        if (Bj_1 < Ai && Ai <= Bj) return Ai;  // found
	        if (Ai_1 < Bj && Bj <= Ai) return Bj;  // found

	        if (Ai <= Bj) return findKthSmallest(A + i + 1, m - (i + 1), B, j, k - (i + 1));
	        else         return findKthSmallest(A, i, B + j + 1, n - (j + 1), k - (j + 1));
	    }
	};
	
}
