
public class _0119_Pascal_s_Triangle_II {

/*	Given an index k, return the kth row of the Pascal's triangle.

	For example, given k = 3,
	Return [1,3,3,1].

	Note:
	Could you optimize your algorithm to use only O(k) extra space?*/
	
	class Solution {
	public:
	    vector<int> getRow(int rowIndex) {
	        vector<int> ans;
	        for (int i = 0; i <= rowIndex / 2; i++) {
	            ans.push_back(C(rowIndex, i));
	        }
	        for (int i = rowIndex / 2 + 1; i <= rowIndex; i++) {
	            ans.push_back(ans[rowIndex - i]);
	        }
	        return ans;
	    }
	    long long int C(int n, int k) {
	        double ans = 1;
	        for (int i = 0; i < k; i++) {
	            ans *= (1.0 * n - i) / (k - i);
	        }
	        return ans + 0.002;
	    }
	};
	
}
