
public class _0069_Sqrt_x_ {

/*	Implement int sqrt(int x).

	Compute and return the square root of x.*/
	
/*	class Solution {
	public:
	    int sqrt(int x) {
	        long long int target = x;
	        int min_sqrt = 0;
	        int max_sqrt = 46340;
	        if (target >= max_sqrt * max_sqrt) return max_sqrt;
	        while (1) {
	            int mid = (min_sqrt + max_sqrt) / 2;
	            if (mid * mid <= target && (mid + 1) * (mid + 1) > target) {
	                return mid;
	            } else if (mid * mid > target) {
	                max_sqrt = mid;
	            } else {
	                min_sqrt = mid;
	            }
	        }
	    }
	};*/
	
}
