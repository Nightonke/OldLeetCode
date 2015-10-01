
public class _0046_Permutations {

/*	Given a collection of numbers, return all possible permutations.

			For example,
			[1,2,3] have the following permutations:
			[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].*/
	
	class Solution {
	public:
	    vector<vector<int> > permute(vector<int> &num) {
	        vector<int> n = num;
	        sort(n.begin(), n.end());
	        vector<int> original = n;
	        vector<vector<int> > ans;
	        while (1) {
	            ans.push_back(n);
	            next_permutation(n.begin(), n.end());
	            if (original == n) break;
	        }
	        return ans;
	    }
	};
	
}
