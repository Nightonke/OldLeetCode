
public class _0219_Contains_Duplicate_II {

/*	Given an array of integers and an integer k, find out whether there are two 
 *  distinct indices i and j in the array such that nums[i] = nums[j] and the 
 *  difference between i and j is at most k.*/
	
	bool containsNearbyDuplicate(int* nums, int numsSize, int k) {
		if (numsSize <= 1) return false;
		int length = 100007;
		if (numsSize < length) length = numsSize;
		int * hash = (int*)malloc(sizeof(int) * length);
		int * pos = (int*)malloc(sizeof(int) * length);
		bool * used = (bool*)malloc(sizeof(bool) * length);
		for (int i = 0; i < length; i++) used[i] = false;
		for (int i = 0; i < numsSize; i++) {
			int p = (nums[i] + numsSize) % numsSize;
			while (used[p]) {
				if (hash[p] == nums[i] && i - pos[p] <= k) {
					free(hash);
					free(pos);
					free(used);
					return true;
				}
				p++;
				if (p == length) p = 0;
			}
			hash[p] = nums[i];
			pos[p] = i;
			used[p] = true;
		}
		free(hash);
		free(pos);
		free(used);
		return false;
	}
	
}
