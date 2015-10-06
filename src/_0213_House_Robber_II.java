
public class _0213_House_Robber_II {

/*	Note: This is an extension of House Robber.

	After robbing those houses on that street, the thief has found himself a new 
	place for his thievery so that he will not get too much attention. This 
	time, all houses at this place are arranged in a circle. That means the 
	first house is the neighbor of the last one. Meanwhile, the security system 
	for these houses remain the same as for those in the previous street.

	Given a list of non-negative integers representing the amount of money of 
	each house, determine the maximum amount of money you can rob tonight 
	without alerting the police.*/
	
	#define max(a, b) ((a)>(b)?(a):(b))

	int rob(int* nums, int numsSize) {
		if (numsSize <= 0) return 0;
		if (numsSize == 1) return nums[0];
		int evenMax, ooddMax, include0, i;
		for (i = evenMax = ooddMax = 0; i < numsSize - 1; i++)  // °üº¬nums[0]
			if (i % 2) ooddMax = max(ooddMax + nums[i], evenMax);
			else evenMax = max(evenMax + nums[i], ooddMax);
		include0 = max(evenMax, ooddMax);
		for (i = 1, evenMax = ooddMax = 0; i < numsSize; i++)  // °üº¬nums[n-1]
			if (i % 2) ooddMax = max(ooddMax + nums[i], evenMax);
			else evenMax = max(evenMax + nums[i], ooddMax);
		return max(include0, max(evenMax, ooddMax));
	}
	
}
