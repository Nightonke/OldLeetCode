
public class _0033_Search_in_Rotated_Sorted_Array {

/*	Suppose a sorted array is rotated at some pivot unknown to you beforehand.

	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

	You are given a target value to search. If found in the array return its index, otherwise return -1.

	You may assume no duplicate exists in the array.*/
	
	class Solution {
	public:
	    int search(int A[], int n, int target) {
	        int low = 0, high = n - 1, mid, range = -1;
	        if (A[0] > A[n - 1]) {
	            while (high - low > 1) {
	                mid = low + (high - low) / 2;
	                if (A[mid] > A[high]) {
	                    low = mid;
	                } else if (A[mid] < A[low]) {
	                    high = mid;
	                } else {
	                    return mid;
	                }
	            }
	            range = low;
	        }
	        if (target > A[n - 1]) {
	            low = 0;
	            high = range;
	        } else {
	            low = range + 1;
	            high = n - 1;
	        }
	        while (low <= high) {
	            mid = low + (high - low) / 2;
	            if (A[mid] == target) {
	                return mid;
	            } else if (A[mid] > target) {
	                high = mid - 1;
	            } else {
	                low = mid + 1;
	            }
	        }
	        return -1;
	    }
	};
	
}
