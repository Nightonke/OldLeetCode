
public class _0039_Combination_Sum {

/*	Given a set of candidate numbers (C) and a target number (T), find all 
 * unique combinations in C where the candidate numbers sums to T.

	The same repeated number may be chosen from C unlimited number of times.

	Note:
	All numbers (including target) will be positive integers.
	Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. 
	(ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
	The solution set must not contain duplicate combinations.
	For example, given candidate set 2,3,6,7 and target 7, 
	A solution set is: 
	[7] 
	[2, 2, 3] */
	
	class Solution {
	public:
	    vector<vector<int> > ans;
	    vector<int> can;
	    vector<int> used;
	    int t;
	    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
	        ans.clear();
	        can.clear();
	        for (int i = 0; i < candidates.size(); i++) {
	            if (can.size() != 0 && can.back() == candidates[i]) continue;
	            can.push_back(candidates[i]);
	        }
	        sort(can.begin(), can.end());
	        used.resize(candidates.size());
	        t = target;
	        dfs(0, 0);
	        return ans;
	    }
	    void dfs(int pos, int nowSum) {

	        if (nowSum == t) {
	            vector<int> anAns;
	            for (int i = 0; i < can.size(); i++) {
	                for (int j = 0; j < used[i]; j++) {
	                    anAns.push_back(can[i]);
	                }
	            }
	            ans.push_back(anAns);
	            return;
	        }

	        if (pos >= can.size()) return;

	        for (int i = 0; can[pos] * i + nowSum <= t; i++) {
	            used[pos] = i;
	            dfs(pos + 1, can[pos] * i + nowSum);
	            //if (pos + 1 != can.size()) used[pos + 1] = 0;
	                
	        }
	    }
	};
	
}
