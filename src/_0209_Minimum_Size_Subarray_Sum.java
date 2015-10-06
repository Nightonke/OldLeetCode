
public class _0209_Minimum_Size_Subarray_Sum {

/*	Given an array of n positive integers and a positive integer s, find the 
 *  minimal length of a subarray of which the sum ≥ s. If there isn't one, 
 *  return 0 instead.

	For example, given the array [2,3,1,2,4,3] and s = 7,
	the subarray [4,3] has the minimal length under the problem constraint.

	click to show more practice.

	Credits:
	Special thanks to @Freezen for adding this problem and creating all test 
	cases.*/
	
	// 在不下降的序列中寻找恰好比target小的数出现位置，也即最后一个比target小的数出现的位置
	int binarySearchIncreaseLastSmaller(int l, int r, int target, int * nums) {  
		if (l >= r) return -1;
		while (l < r - 1) {
			int m = l + ((r - l) >> 1);
			if (nums[m] < target) l = m;
			else r = m - 1;
		}
		if (nums[r] < target) return r;
		else if (nums[l] < target) return l;
		else return -1;
	}

	int minSubArrayLen(int s, int * nums, int numsSize) {
		int * Sum = (int*)malloc(sizeof(int) * (numsSize + 1)), minL = numsSize + 1;
		Sum[0] = 0;
		for (int i = 1; i <= numsSize; i++) Sum[i] = Sum[i - 1] + nums[i - 1];
		for (int i = 1; i <= numsSize; i++) {
			if (Sum[i] >= s) {
				int k = Sum[i];
				int BeforePos = binarySearchIncreaseLastSmaller(0, i, Sum[i] - s + 1, Sum);
				if (BeforePos != -1 && i - BeforePos < minL) minL = i - BeforePos;
			}
		}
		return minL == numsSize + 1 ? 0 : minL;
	}
	
}
