
public class _0163_Missing_Ranges {

/*	Given a sorted integer array where the range of elements are [lower, upper] 
 *  inclusive, return its missing ranges.

	For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", 
	"4->49", "51->74", "76->99"].*/
	
	class Solution {
	public:
	    
	    string int2string(int i) {
	        string s;
	        char c[20];
	        sprintf(c, "%d", i);
	        s = c;
	        return s;
	    }

	    string int2range(int i1, int i2) {
	        if (i1 == i2) {
	            return int2string(i1);
	        }
	        else {
	            return int2string(i1) + "->" + int2string(i2);
	        }
	    }

	    vector<string> findMissingRanges(vector<int>& nums, int lower, int upper) {
	        vector<string> ans;
	        if (nums.size() == 0 || lower > nums.back() || upper < nums.front()) {
	            ans.push_back(int2range(lower, upper));
	        }
	        else {
	            vector<int> ns;
	            ns.push_back(lower - 1);
	            ns.insert(ns.end(), nums.begin(), nums.end());
	            ns.push_back(upper + 1);
	            for (int i = 0; i < ns.size() - 1; i++) {
	                int i1 = ns[i] + 1;
	                int i2 = ns[i + 1] - 1;
	                if (i1 <= i2) {
	                    ans.push_back(int2range(i1, i2));
	                }
	            }
	        }
	        return ans;
	    }
	};
	
}
