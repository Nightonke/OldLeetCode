
public class _0229_Majority_Element_II {

/*   Given an integer array of size n, find all elements that appear more 
 *   than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) 
 *   space.
	*/
	
	class Solution {
	public:
	    vector<int> majorityElement(vector<int>& nums) {
	        vector<int> ans;
	        if (nums.size() == 0) return ans;
	        int can1, can2, count1, count2, s = nums.size();
	        can1 = can2 = nums[0] - 1;
	        count1 = count2 = 0;
	        for (int i = 0; i < s; i++) {
	            if (nums[i] == can1) count1++;
	            else if (nums[i] == can2) count2++;
	            else if (count1 == 0) can1 = nums[i], count1 = 1;
	            else if (count2 == 0) can2 = nums[i], count2 = 1;
	            else count1--, count2--;
	        }
	        count1 = count2 = 0;
	        for (int i = 0; i < s; i++) {
	            if (nums[i] == can1) count1++;
	            if (nums[i] == can2) count2++;
	        }
	        if (count1 > s / 3) ans.push_back(can1);
	        if (count2 > s / 3 && can2 != can1) ans.push_back(can2);
	        return ans;
	    }
	};

	
}
