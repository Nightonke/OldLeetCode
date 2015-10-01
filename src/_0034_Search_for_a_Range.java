
public class _0034_Search_for_a_Range {

/*	Given a sorted array of integers, find the starting and ending position of 
 * a given target value.

	Your algorithm's runtime complexity must be in the order of O(log n).

	If the target is not found in the array, return [-1, -1].

	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].*/
	
	class Solution {
	public:
	    vector<int> searchRange(int A[], int n, int target) {
	        vector<int> ans;
	        ans.push_back(find2Side(true, A, n, target));
	        ans.push_back(find2Side(false, A, n, target));
	        return ans;
	    }
	    int find2Side (bool findLeftSide, int A[], int n, int target) {
	        int low = 0, high = n - 1, mid;
	        while (low <= high) {
	            mid = low + (high - low) / 2;
	            if (A[mid] == target) {
	                if (findLeftSide) {  // 如果找左界
	                    if (mid == 0 || (A[mid - 1] != target)) {  // 符合左界情况
	                        return mid;
	                    } else {
	                        high = mid - 1;  // 否则往左边找
	                        continue;
	                    }
	                }
	                if (!findLeftSide) {
	                    if (mid == n - 1 || (A[mid + 1] != target)) {
	                        return mid;
	                    } else {
	                        low = mid + 1;
	                        continue;
	                    }
	                }

	            }
	            if (A[mid] > target) {
	                high = mid - 1;
	            } else {
	                low = mid + 1;
	            }
	        }
	        return -1;
	    }
	};
	
}
