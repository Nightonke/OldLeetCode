
public class _0078_Subsets {

/*	Given a set of distinct integers, nums, return all possible subsets.

			Note:
			Elements in a subset must be in non-descending order.
			The solution set must not contain duplicate subsets.
			For example,
			If nums = [1,2,3], a solution is:

			[
			  [3],
			  [1],
			  [2],
			  [1,2,3],
			  [1,3],
			  [2,3],
			  [1,2],
			  []
			]*/
	
	class Solution {
	public:
	    vector<vector<int> > subsets(vector<int> &S) {
	        sort(S.begin(), S.end());
	        vector<vector<int> > result(1);
	        int oldval=S[0];
	        int oldj=0;
	        for(int i=0; i<S.size(); i++){
	            int temp=oldj;
	            if(S[i]!=oldval){
	                oldval=S[i]; temp=0;
	            }
	            int j=result.size();
	            oldj=j;
	            while(j-->temp){
	                result.push_back(result[j]);
	                result.back().push_back(S[i]);
	            }
	        }
	        return result;
	    }
	};
	
}
