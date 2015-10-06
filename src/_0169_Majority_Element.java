
public class _0169_Majority_Element {

/*	Given an array of size n, find the majority element. The majority element is 
 *  the element that appears more than ⌊ n/2 ⌋ times.

	You may assume that the array is non-empty and the majority element always 
	exist in the array.*/
	
	class Solution {
	public:
	    int majorityElement(vector<int> & num) {
	        int target, p = -1;
	        int n = num.size();
	        for (int i = 0; i < n; i++)
	            if (target != num[i] || p == -1)
	                if (p <= 0) {
	                    target = num[i];
	                    p = 1;
	                } else p--;
	            else p++;
	        return target;
	    }
	};
	
}
