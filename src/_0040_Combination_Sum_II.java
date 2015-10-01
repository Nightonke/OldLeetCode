
public class _0040_Combination_Sum_II {

/*	Given a collection of candidate numbers (C) and a target number (T), find 
 *  all unique combinations in C where the candidate numbers sums to T.

	Each number in C may only be used once in the combination.

	Note:
	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order.
	 (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
	The solution set must not contain duplicate combinations.
	For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
	A solution set is: 
	[1, 7] 
	[1, 2, 5] 
	[2, 6] 
	[1, 1, 6] */
	
	class Solution {
	public:
	    vector<vector<int> > ans;  // answer
	    vector<int> can;  // "can" is a vector from candidates after processing
	    vector<bool> used;
	    int t;
	    vector<vector<int> > combinationSum2(vector<int> &num, int target) {
	        ans.clear();
	        can = num;
	        sort(can.begin(), can.end());  // to make sure that the solutions in ans is in non-descending order
	        used.resize(can.size());
	        t = target;
	        dfs(0, 0);
	        sort(ans.begin(), ans.end());
	        vector<vector<int> > trueAns;
	        for (int i = 0; i < ans.size(); i++) {
	            if (trueAns.size() > 0 && trueAns.back() == ans[i]) continue;
	            trueAns.push_back(ans[i]);
	        }
	        return trueAns;
	    }
	    void dfs(int pos, int nowSum) {

	        if (nowSum == t) {
	            vector<int> anAns;
	            for (int i = 0; i < can.size(); i++) {
	                if (used[i]) anAns.push_back(can[i]);
	            }
	            ans.push_back(anAns);
	            return;
	        }

	        if (nowSum > t || pos >= can.size()) return;

	        used[pos] = false;
	        dfs(pos + 1, nowSum);
	        if (can[pos] + nowSum <= t) {
	            used[pos] = true;
	            dfs(pos + 1, can[pos] + nowSum);
	            used[pos] = false;
	        }
	    }
	};
	
}
