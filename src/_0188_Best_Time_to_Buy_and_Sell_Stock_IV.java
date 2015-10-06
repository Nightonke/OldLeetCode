
public class _0188_Best_Time_to_Buy_and_Sell_Stock_IV {

/*	Say you have an array for which the ith element is the price of a given 
 *  stock on day i.

	Design an algorithm to find the maximum profit. You may complete at most k 
	transactions.

	Note:
	You may not engage in multiple transactions at the same time (ie, you must 
	sell the stock before you buy again).*/
	
	class Solution {
	public:
		int maxProfit(int k, vector<int> &prices) {
			if (k >= prices.size() / 2) return maxProfit(prices);
			if (prices.size() == 0) return 0;
			int * h = new int[k + 1], *r = new int[k + 1], s = prices.size();
			for (int i = 1; i <= k; i++) h[i] = -prices[0], r[i] = 0;
			h[0] = r[0] = 0;
			for (int i = 0; i < s; i++)
				for (int j = k; j > 0; j--) {
					if (h[j] + prices[i] > r[j]) r[j] = h[j] + prices[i];
					if (r[j - 1] - prices[i] > h[j]) h[j] = r[j - 1] - prices[i];
				}
			s = r[k];
			delete[]h, delete[]r;
			return s;
		}
		int maxProfit(vector<int> &prices) {
			int ans = 0, s = prices.size();
			for (int i = 1; i < s; i++)
				if (prices[i] > prices[i - 1]) ans += prices[i] - prices[i - 1];
			return ans;
		}
	};

	
}
