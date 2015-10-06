
public class _0154_Find_Minimum_in_Rotated_Sorted_Array_II {

/*	Follow up for "Find Minimum in Rotated Sorted Array":
	What if duplicates are allowed?

	Would this affect the run-time complexity? How and why?
	Suppose a sorted array is rotated at some pivot unknown to you beforehand.

	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

	Find the minimum element.

	The array may contain duplicates.*/
	
	class Solution {
	public:
	    vector<int> Num;
	    int findMin(vector<int> & num) {
	        if (num.size() == 1) return num[0];
	        if (num[0] < num[num.size() - 1]) return num[0];
	        Num = num;
	        return findGap(0, Num.size() - 1);
	    }
	    int findGap(int l, int h) {

	        if (l == h - 1) return (Num[l] < Num[h] ? Num[l] : Num[h]);
	        
	        int mid = (l + h) / 2;

	        if (Num[l] > Num[mid]) return findGap(l, mid);
	        else if (Num[l] < Num[mid]) return findGap(mid, h);
	        else return min(findGap(l, mid), findGap(mid, h));

	    }
	};
	
}
