
public class _0153_Find_Minimum_in_Rotated_Sorted_Array {

/*	Suppose a sorted array is rotated at some pivot unknown to you beforehand.

	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

	Find the minimum element.

	You may assume no duplicate exists in the array.*/
	
	class Solution {
	public:
	    int findMin(vector<int> & num) {
	        if (num.size() == 1) return num[0];
	        if (num[0] < num[num.size() - 1]) return num[0];
	        return num[findGap(num)];
	    }
	    int findGap(vector<int> & num) {

	        int l = 0, h = num.size() - 1;

	        while (l <= h) {

	            if (l == h - 1) return h;

	            int m = (l + h) / 2;

	            if (num[l] > num[m]) {
	                h = m;
	            } else if (num[m] > num[h]) {
	                l = m;
	            }

	        }

	        return -1;

	    }
	};
	
}
