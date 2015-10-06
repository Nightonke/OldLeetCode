
public class _0164_Maximum_Gap {

/*	Given an unsorted array, find the maximum difference between the successive 
 *  elements in its sorted form.

	Try to solve it in linear time/space.

	Return 0 if the array contains less than 2 elements.

	You may assume all elements in the array are non-negative integers and fit 
	in the 32-bit signed integer range.*/
	
	class Solution {
	public:
	    int maximumGap(vector<int> &num) {
	        vector<int> n = num;
	        sort(n.begin(), n.end());
	        int ans = 0, s = n.size();
	        for (int i = 1; i < s; i++)
	            if (ans < n[i] - n[i - 1]) ans = n[i] - n[i - 1];
	        return ans;
	    }
	};
	
}
