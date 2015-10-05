
public class _0137_Single_Number_II {

/*	Given an array of integers, every element appears three times except for 
 *  one. Find that single one.

	Note:
	Your algorithm should have a linear runtime complexity. Could you implement 
	it without using extra memory?*/

	class Solution {
	public:
	    int interchange(int A[], int low, int high) {
	        int key = A[low];
	        while (low < high) {
	            while (low < high && A[high] >= key) high--;
	            if (low < high) A[low++] = A[high];
	            while (low < high && A[low] <= key) low++;
	            if (low < high) A[high--] = A[low];
	        }
	        A[low] = key;
	        return low;
	    }
	    void quicksort(int A[], int low, int high) {
	        int new_mid;
	        if (low < high) {
	            new_mid = interchange(A, low, high);
	            quicksort(A, low, new_mid - 1);
	            quicksort(A, new_mid + 1, high);
	        }
	    }
	    int singleNumber(int A[], int n) {
	        if (n < 3) return A[0];
	        
	        quicksort(A, 0, n - 1);
	        int counter = 1;
	        for (int i = 1; i < n; i++) {
	            if (A[i] == A[i - 1]) {
	                counter++;
	            } else {
	                if (counter != 3) {
	                    return A[i - 1];
	                } else {
	                    counter = 1;
	                }
	            }
	        }
	        return A[n - 1];
	    }
	};
	
}
