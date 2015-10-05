
public class _0135_Candy {

/*	There are N children standing in a line. Each child is assigned a rating value.

	You are giving candies to these children subjected to the following requirements:

	Each child must have at least one candy.
	Children with a higher rating get more candies than their neighbors.
	What is the minimum candies you must give?*/
	
	class Solution {
	public:
	    int candy(vector<int> &ratings) {
	        int ans = 0;
	        int * lc = new int[ratings.size()];
	        int * rc = new int[ratings.size()];
	        for (int i = 0; i < ratings.size(); i++) lc[i] = rc[i] = 1;
	        for (int i = 1; i < ratings.size(); i++) if (ratings[i - 1] < ratings[i]) lc[i] = lc[i - 1] + 1;
	        for (int i = ratings.size() - 2; i >= 0; i--) if (ratings[i] > ratings[i + 1]) rc[i] = rc[i + 1] + 1;
	        for (int i = 0; i < ratings.size(); i++) ans += max(lc[i], rc[i]);
	        return ans;
	    }
	};
	
}
