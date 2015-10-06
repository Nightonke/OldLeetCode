
public class _0162_Find_Peak_Element {

/*	A peak element is an element that is greater than its neighbors.

	Given an input array where num[i] ¡Ù num[i+1], find a peak element and return 
	its index.

	The array may contain multiple peaks, in that case return the index to any 
	one of the peaks is fine.

	You may imagine that num[-1] = num[n] = -¡Þ.

	For example, in array [1, 2, 3, 1], 3 is a peak element and your function 
	should return the index number 2.

	click to show spoilers.

	Credits:
	Special thanks to @ts for adding this problem and creating all test cases.*/
	
	class Solution {
	public:
	    int findPeakElement(const vector<int> &num) {
	        if (num.size() <= 1) return 0;
	        int l = 0, r = num.size() - 1, mid, s = num.size() - 1;
	        while (l <= r) {
	            mid = (l + r) / 2;
	            if ((mid == 0 && num[mid] > num[mid + 1]) || (mid == s && num[mid - 1] < num[mid]) || (num[mid - 1] < num[mid] && num[mid] > num[mid + 1])) return mid;
	            else if ((mid == 0 && num[mid] < num[mid + 1]) || (num[mid - 1] < num[mid] && num[mid] < num[mid + 1])) l = mid + 1;
	            else if ((mid == s && num[mid - 1] > num[mid]) || (num[mid - 1] > num[mid] && num[mid] > num[mid + 1])) r = mid - 1;
	            else r = mid - 1;
	        }
	    }
	};
	
}
