
public class _0122_Best_Time_to_Buy_and_Sell_Stock_II {

/*	Say you have an array for which the ith element is the price of a given 
 *  stock on day i.

	Design an algorithm to find the maximum profit. You may complete as many 
	transactions as you like (ie, buy one and sell one share of the stock 
	multiple times). However, you may not engage in multiple transactions at the 
	same time (ie, you must sell the stock before you buy again).*/
	
	class Solution {
	public:
		int maxProfit(vector<int> &prices) {
			int ans = 0, s = prices.size();
			for (int i = 1; i < s; i++)
				if (prices[i] > prices[i - 1]) ans += prices[i] - prices[i - 1];
			return ans;
		}
	};
	
}
