
public class _0055_Jump_Game {

/*	Given an array of non-negative integers, you are initially positioned at the 
 *  first index of the array.

	Each element in the array represents your maximum jump length at that 
	position.

	Determine if you are able to reach the last index.

	For example:
	A = [2,3,1,1,4], return true.

	A = [3,2,1,0,4], return false.*/
	
	class Solution {
	public:
	    bool canJump(int A[], int n) {
	        int canReach = 0;  // the original canReach point is the starting point
	        for (int i = 0; i < n && i <= canReach; i++) {
	            if (i + A[i] > canReach) canReach = i + A[i];
	            if (canReach >= n - 1) return true;
	        }
	        return canReach >= n - 1;
	    }
	};
	
}
