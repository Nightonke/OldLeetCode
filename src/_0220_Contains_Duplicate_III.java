
public class _0220_Contains_Duplicate_III {

/*	Given an array of integers, find out whether there are two distinct indices 
 *  i and j in the array such that the difference between nums[i] and nums[j] 
 *  is at most t and the difference between i and j is at most k.*/
	
	struct num {
	    int pos, val;
	};

	int AD(struct num * nums, int l, int r) {
	    int K = nums[l].val;
	    int Kp = nums[l].pos;
	    while (l < r) {
	        while (l < r && nums[r].val > K) r--;
	        if (l < r) nums[l++] = nums[r];
	        while (l < r && nums[l].val < K) l++;
	        if (l < r) nums[r--] = nums[l];
	    }
	    nums[l].val = K;
	    nums[l].pos = Kp;
	    return l;
	}

	void QS(struct num * nums, int l, int r) {
	    if (l < r) {
	        int mid = AD(nums, l, r);
	        QS(nums, l, mid - 1);
	        QS(nums, mid + 1, r);
	    }
	}

	// 在不下降的序列中寻找恰好比target大的数出现位置，也即第一个比target大的数出现的位置
	int binarySearchIncreaseFirstBigger(struct num * nums, int l, int r, int target) {  
	    if (r - l + 1 == 0) return -1;
	    while (l < r) {
	        int m = l + ((r - l) >> 1);
	        if (nums[m].val <= target) l = m + 1;
	        else r = m;
	    }
	    if (nums[r].val > target) return r;
	    else return -1;
	}

	bool containsNearbyAlmostDuplicate(int* nums, int numsSize, int k, int t) {
	    struct num * N = (struct num*)malloc(sizeof(struct num) * numsSize);
	    for (int i = 0; i < numsSize; i++) N[i].pos = i, N[i].val = nums[i];
	    QS(N, 0, numsSize - 1);
	    for (int i = 1; i < numsSize; i++) {
	        int minPos = binarySearchIncreaseFirstBigger(N, 0, i - 1, N[i].val - t - 1);
	        if (minPos == -1) {

	        }
	        else {
	            for (int j = minPos; j < i; j++) {
	                if (abs(N[i].pos - N[j].pos) <= k) {
	                    free(N);
	                    return true;
	                }
	            }
	        }
	    }
	    free(N);
	    return false;
	}
	
}
