
public class _0228_Summary_Ranges {

/*	Given a sorted integer array without duplicates, return the summary of its ranges.

	For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].*/

	class Solution {
	public:
	    vector<string> summaryRanges(vector<int>& nums) {
	        vector<string> ans;
	        if (nums.size() == 0) return ans;
	        int startPosition = 0, nowPosition = 1;
	        for (; nowPosition <= nums.size(); nowPosition++) {
	            if (nowPosition == nums.size() || nums[nowPosition] > nums[nowPosition - 1] + 1) {
	                if (startPosition != nowPosition - 1) {
	                    ans.push_back(toS(nums[startPosition]) + "->" + toS(nums[nowPosition - 1]));
	                }
	                else {
	                    ans.push_back(toS(nums[startPosition]));
	                }
	                startPosition = nowPosition;
	            }
	        }
	        return ans;
	    }
	    string toS(int i) {
	        char t[20];
	        string s;
	        sprintf(t, "%d", i);
	        s = t;
	        return s;
	    }
	};
	
}
