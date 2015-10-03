
public class _0077_Combinations {

/*	Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

			For example,
			If n = 4 and k = 2, a solution is:

			[
			  [2,4],
			  [3,4],
			  [2,3],
			  [1,2],
			  [1,3],
			  [1,4],
			]
*/
	
	class Solution {
	public:
	    vector<vector<int> > combine(int n, int k) {
	        N = n;
	        K = k;
	        used.resize(n + 1);
	        for (int i = 1; i <= N; used[i++] = false);
	        ans.clear();
	        dfs(0, 0);
	        return ans;
	    }
	    vector<bool> used;
	    vector<vector<int> > ans;
	    int K, N;
	    void dfs(int st, int num) {
	        if (num == K) {
	            vector<int> a;
	            for (int i = 1; i <= N; i++) {
	                if (used[i]) a.push_back(i); 
	            }
	            ans.push_back(a);
	            return;
	        }
	        for (int i = st + 1; i <= N; i++) {
	            if (!used[i]) {
	                used[i] = true;
	                dfs(i, num + 1);
	                used[i] = false;
	            }
	        }
	    }
	};
	
}
