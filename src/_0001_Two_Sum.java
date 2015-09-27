
public class _0001_Two_Sum {

//	Given an array of integers, find two numbers such that they add up to a 
//	specific target number.
//
//	The function twoSum should return indices of the two numbers such that they 
//	add up to the target, where index1 must be less than index2. Please note 
//	that your returned answers (both index1 and index2) are not zero-based.
//
//	You may assume that each input would have exactly one solution.
//
//	Input: numbers={2, 7, 11, 15}, target=9
//	Output: index1=1, index2=2
	
	struct bag {
	    int data;
	    int pos;
	    bag(int d, int p) {
	        data = d;
	        pos = p;
	    }
	};
	bool cmp(bag a, bag b) {
	    return a.data < b.data;
	}
	class Solution {
	public:
	    int bSearch(int target, vector<bag> n, int nonPos) {
	        int l = 0, h = n.size() - 1;
	        while (l <= h) {
	            int mid = (l + h) / 2;
	            if (target == n[mid].data) {
	                if (mid != nonPos) return mid;
	                else
	                    if (n[mid].data == n[mid + 1].data) return mid + 1;
	                    else return mid - 1;
	            }
	            if (target < n[mid].data) h = mid - 1;
	            if (target > n[mid].data) l = mid + 1;
	        }
	        return -1;
	    }
	    vector<int> twoSum(vector<int> &numbers, int target) {
	        vector<bag> b;
	        for (int i = 0; i < numbers.size(); i++) b.push_back(bag(numbers[i], i));
	        sort(b.begin(), b.end(), cmp);
	        for (int i = 0; i < b.size(); i++) {
	            int ans1 = bSearch(target - b[i].data, b, i);
	            if (ans1 != -1) {
	                vector<int> ans;
	                ans.push_back(b[i].pos + 1);
	                ans.push_back(b[ans1].pos + 1);
	                sort(ans.begin(), ans.end());
	                return ans;
	            }
	        }
	    }
	};
	
}
