
public class _0088_Merge_Sorted_Array {

/*	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as 
 *  one sorted array.

	Note:
	You may assume that nums1 has enough space (size that is greater or equal to 
	m + n) to hold additional elements from nums2. The number of elements 
	initialized in nums1 and nums2 are m and n respectively.*/
	
	class Solution {
	public:
	    void merge(int A[], int m, int B[], int n) {
	        int temp[m + n];int pa, pb, pt;
	        for (pa = pb = pt = 0; pa < m || pb < n; ) {
	            if ((pb == n) || (pa < m && A[pa] < B[pb])) temp[pt++] = A[pa++];
	            else if ((pa == m) || (pb < n && A[pa] >= B[pb])) temp[pt++] = B[pb++];
	        }
	        for (int i = 0; i < m + n; i++) A[i] = temp[i];
	    }
	};
	
}
