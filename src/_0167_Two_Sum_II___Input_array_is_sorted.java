
public class _0167_Two_Sum_II___Input_array_is_sorted {

/*	Given an array of integers that is already sorted in ascending order, find 
 *  two numbers such that they add up to a specific target number.

	The function twoSum should return indices of the two numbers such that they 
	add up to the target, where index1 must be less than index2. Please note 
	that your returned answers (both index1 and index2) are not zero-based.

	You may assume that each input would have exactly one solution.

	Input: numbers={2, 7, 11, 15}, target=9
	Output: index1=1, index2=2*/
	
	class Solution {
	public:
	    vector<int> twoSum(vector<int>& numbers, int target) {
	        for (int i = 0; i < numbers.size(); i++) {
	            int i2 = target - numbers[i];
	            int l = i + 1, r = numbers.size() - 1;
	            while (l < r) {
	                int m = l + ((r - l) >> 1);
	                if (numbers[m] < i2) l = m + 1;
	                else r = m;
	            }
	            if (numbers[l] == i2) {
	                vector<int> ans;
	                ans.push_back(i + 1);
	                ans.push_back(l + 1);
	                return ans;
	            }
	        }
	    }
	};
	
}
