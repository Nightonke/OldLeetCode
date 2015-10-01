
public class _0070_Climbing_Stairs {

/*	You are climbing a stair case. It takes n steps to reach to the top.

	Each time you can either climb 1 or 2 steps. In how many distinct ways can 
	you climb to the top?*/
	
	class Solution {
	public:
	    int climbStairs(int n) {
	        vector<int> s(n + 5);
	        s[0] = 1;
	        s[1] = 1;
	        for (int i = 2; i <= n; i++) {
	            s[i] = s[i - 1] + s[i - 2];
	        }
	        return s[n];
	    }
	};
	
}
