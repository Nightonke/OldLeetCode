
public class _0026_Remove_Duplicates_from_Sorted_Array {

/*	Given a sorted array, remove the duplicates in place such that each element 
 *  appear only once and return the new length.

			Do not allocate extra space for another array, you must do this in 
			place with constant memory.

			For example,
			Given input array nums = [1,1,2],

			Your function should return length = 2, with the first two elements 
			of nums being 1 and 2 respectively. It doesn't matter what you leave 
			beyond the new length.
*/	
	
	class Solution {
	public:
	    int removeDuplicates(int A[], int n) {
	        if (!n) return 0;
	        int cmp[n];
	        cmp[0] = A[0];
	        int counter = 1;
	        for (int i = 1; i < n; i++) {
	            if (cmp[counter - 1] != A[i]) {
	                cmp[counter++] = A[i];
	            }
	        }
	        for (int i = 0; i < counter; i++) A[i] = cmp[i];
	        return counter;
	    }
	};
	
}
