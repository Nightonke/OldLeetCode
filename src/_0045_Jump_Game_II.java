
public class _0045_Jump_Game_II {

/*	Given an array of non-negative integers, you are initially positioned at the 
 *  first index of the array.

	Each element in the array represents your maximum jump length at that 
	position.

	Your goal is to reach the last index in the minimum number of jumps.

	For example:
	Given array A = [2,3,1,1,4]

	The minimum number of jumps to reach the last index is 2. (Jump 1 step from 
	index 0 to 1, then 3 steps to the last index.)*/
	
	class Solution {
	public:
	    int jump(int A[], int n) {
	        int * step = new int[n];
	        step[0] = 0;
	        int pos = 1;
	        for (int i = 0; i < n; i++) {
	            int j;
	            for (j = pos; j <= A[i] + i && j < n; j++) {
	                step[j] = step[i] + 1;
	            }
	            pos = j;
	        }
	        int ans = step[n - 1];
	        delete []step;
	        return ans;
	    }
	};
	
}
