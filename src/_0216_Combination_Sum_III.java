
public class _0216_Combination_Sum_III {

/*	Find all possible combinations of k numbers that add up to a number n, given 
 *  that only numbers from 1 to 9 can be used and each combination should be a 
 *  unique set of numbers.

	Ensure that numbers within the set are sorted in ascending order.


	Example 1:

	Input: k = 3, n = 7

	Output:

	[[1,2,4]]

	Example 2:

	Input: k = 3, n = 9

	Output:

	[[1,2,6], [1,3,5], [2,3,4]]*/
	
	class Solution {
	public:
		vector<vector<int>> Ans;
		vector<int> AnAns;
		int K;
		int N;
		vector<vector<int> > combinationSum3(int k, int n) {
			K = k;
			N = n;
			Ans.clear();
			AnAns.resize(k);
			for (int i = 1; i <= 9; i++) AnAns[0] = i, DFS(i, 1);
			return Ans;
		}
		void DFS(int sum, int p) {
			if (p == K) {
				if (sum == N) Ans.push_back(AnAns);
				return;
			}
			for (int i = AnAns[p - 1] + 1; i <= 9; i++) {
				if (sum + i <= N) {
					AnAns[p] = i;
					DFS(sum + i, p + 1);
				}
				else return;
			}
		}
	};
	
}
