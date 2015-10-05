
public class _0123_Best_Time_to_Buy_and_Sell_Stock_III {

/*	Say you have an array for which the ith element is the price of a given 
 *  stock on day i.

	Design an algorithm to find the maximum profit. You may complete at most two 
	transactions.

	Note:
	You may not engage in multiple transactions at the same time (ie, you must 
	sell the stock before you buy again).*/
	
	class Solution {
	public:
		int maxProfit(vector<int> &prices) {
			if (prices.size() == 0) return 0;
			int h1 = -prices[0], h2 = -prices[0], r1 = 0, r2 = 0, s = prices.size();
			for (int i = 0; i < s; i++) {
				if (h2 + prices[i] > r2) r2 = h2 + prices[i];
				if (r1 - prices[i] > h2) h2 = r1 - prices[i];
				if (h1 + prices[i] > r1) r1 = h1 + prices[i];
				if (-prices[i] > h1) h1 = -prices[i];
			}
			return r2;
		}
	};
	
}
