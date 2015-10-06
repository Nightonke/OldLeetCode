
public class _0217_Contains_Duplicate {

/*	Given an array of integers, find if the array contains any duplicates. Your 
 *  function should return true if any value appears at least twice in the 
 *  array, and it should return false if every element is distinct.*/
	
	bool containsDuplicate(int* nums, int numsSize) {
		if (numsSize <= 1) return false;
		int length = 100007;
		if (numsSize < length) length = numsSize;
		int * hash = (int*)malloc(sizeof(int) * length);
		bool * used = (bool*)malloc(sizeof(bool) * length);
		for (int i = 0; i < length; i++) used[i] = false;
		for (int i = 0; i < numsSize; i++) {
			int p = (nums[i] + numsSize) % numsSize;
			while (used[p]) {
				if (hash[p] == nums[i]) {
					free(hash);
					free(used);
					return true;
				}
				p++;
				if (p == length) p = 0;
			}
			hash[p] = nums[i];
			used[p] = true;
		}
		free(hash);
		free(used);
		return false;
	}
	
}
