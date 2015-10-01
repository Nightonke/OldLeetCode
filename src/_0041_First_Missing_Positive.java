
public class _0041_First_Missing_Positive {

/*	Given an unsorted integer array, find the first missing positive integer.

	For example,
	Given [1,2,0] return 3,
	and [3,4,-1,1] return 2.

	Your algorithm should run in O(n) time and uses constant space.*/
	
	class Solution {
	public:
	    int firstMissingPositive(int A[], int n) {
	        if (n == 0) return 1;
	        //if (n == 1) return A[0] == 1 ? 2 : 1;
	        int last;
	        for (int i = 0; i < n; i++) {
	            int target = A[i];
	            
	            while (0 <= target && target < n && target != A[target]) {
	                swap(target, A[target]);
	            }
	            if (target == n) last = target;
	        }
	        for (int i = 1; i <= n; i++) {
	            if (i == n) {
	                if (last != i) return i;
	                else return n + 1;
	            }
	            if (A[i] != i) return i;
	        }
	        return n;
	    }
	};
	
}
