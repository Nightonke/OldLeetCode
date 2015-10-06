
public class _0215_Kth_Largest_Element_in_an_Array {

/*	Find the kth largest element in an unsorted array. Note that it is the kth 
 *  largest element in the sorted order, not the kth distinct element.

	For example,
	Given [3,2,1,5,6,4] and k = 2, return 5.

	Note: 
	You may assume k is always valid, 1 ¡Ü k ¡Ü array's length.
*/	
	
	int Adjust(int * nums, int l, int r) {
		int K = nums[l];
		while (l < r) {
			while (l < r && nums[r] <= K) r--;
			nums[l] = nums[r];
			while (l < r && nums[l] >= K) l++;
			nums[r] = nums[l];
		}
		nums[l] = K;
		return l;
	}

	int QS(int * nums, int l, int r, int k) {
		if (l <= r) {
			int mid = Adjust(nums, l, r);
			if (k == mid) return nums[mid];
			if (k < mid) return QS(nums, l, mid - 1, k);
			if (k > mid) return QS(nums, mid + 1, r, k);
		}
	}

	int findKthLargest(int* nums, int numsSize, int k) {
		return QS(nums, 0, numsSize - 1, k - 1);
	}
	
}
