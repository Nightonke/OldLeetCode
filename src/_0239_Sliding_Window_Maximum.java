
public class _0239_Sliding_Window_Maximum {

//	Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
//	For example,
//	Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
//
//	Window position                Max
//	---------------               -----
//	[1  3  -1] -3  5  3  6  7       3
//	 1 [3  -1  -3] 5  3  6  7       3
//	 1  3 [-1  -3  5] 3  6  7       5
//	 1  3  -1 [-3  5  3] 6  7       5
//	 1  3  -1  -3 [5  3  6] 7       6
//	 1  3  -1  -3  5 [3  6  7]      7
//	Therefore, return the max sliding window as [3,3,5,5,6,7].
//
//	Note: 
//	You may assume k is always valid, ie: 1 ¡Ü k ¡Ü input array's size for non-empty array.
//
//	Follow up:
//	Could you solve it in linear time?
//
//	Show Hint 
//	Subscribe to see which companies asked this question
	
	class Solution {
	public:
	    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
	        vector<int> ans;
	        deque<int> q;
	        int size = nums.size();
	        for (int i = 0; i < size; i++) {
	            // pop the front entities those're out of range
	            while (!q.empty() && q.front() < i - k + 1) q.pop_front();
	            // pop the tail entities those're less that nums[i]
	            // they get no change to be the max
	            while (!q.empty() && nums[q.back()] < nums[i]) q.pop_back();
	            // the front is the max, because the front is pop
	            // and it is not popped for the new entity
	            q.push_back(i);
	            if (i >= k - 1) ans.push_back(nums[q.front()]);
	        }
	        return ans;
	    }
	};
	
}
