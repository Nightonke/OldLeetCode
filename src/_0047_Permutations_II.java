
public class _0047_Permutations_II {

/*	Given a collection of numbers that might contain duplicates, 
 *  return all possible unique permutations.

			For example,
			[1,1,2] have the following unique permutations:
			[1,1,2], [1,2,1], and [2,1,1].*/
	
	class Solution {
	public:
	    vector<vector<int> > permuteUnique(vector<int> &num) {
	        vector<int> n = num;
	        sort(n.begin(), n.end());
	        vector<int> ori = n;
	        vector<vector<int> > ans;
	        while (1) {
	            ans.push_back(n);
	            next_permutation(n.begin(), n.end());
	            if (n == ori) break;
	        }
	        return ans;
	    }
	};
	
}
