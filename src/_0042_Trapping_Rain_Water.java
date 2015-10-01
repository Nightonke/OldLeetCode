
public class _0042_Trapping_Rain_Water {

/*	Given n non-negative integers representing an elevation map where the width 
 *  of each bar is 1, compute how much water it is able to trap after raining.

	For example, 
	Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


	The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
	In this case, 6 units of rain water (blue section) are being trapped. Thanks 
	Marcos for contributing this image!*/
	
	class Solution {
	public:
	    int trap(int A[], int n) {
	        int * lmax = new int[n];
	        int * rmax = new int[n];
	        for (int i = 0, Max = -1; i < n; i++) lmax[i] = Max = max(A[i], Max);
	        for (int i = n - 1, Max = -1; i >= 0; i--) rmax[i] = Max = max(A[i], Max);
	        int ans = 0;
	        for (int i = 0; i < n; i++) ans += min(lmax[i], rmax[i]) - A[i];
	        delete []lmax;
	        delete []rmax;
	        return ans;
	    }
	};
	
}
