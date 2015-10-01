
public class _0016_3Sum_Closest {

/*	Given an array S of n integers, find three integers in S such that the sum 
 * is closest to a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/
	
	class Solution {
	public:
	    int threeSumClosest(vector<int> &num, int target) {
	        int ans;
	        int error;
	        int min_error = 999999;
	        for (int i = 0; i < num.size(); i++) {
	            for (int j = i + 1; j < num.size(); j++) {
	                for (int k = j + 1; k < num.size(); k++) {
	                    error = num[i] + num[j] + num[k] - target;
	                    if (error < 0) {
	                        error = -error;
	                    }
	                    if (error < min_error) {
	                        ans = num[i] + num[j] + num[k];
	                        min_error = error;
	                    }
	                    if (error == 0) {
	                        return target;
	                    }
	                }
	            }
	        }
	        return ans;
	    }
	};
	
}
