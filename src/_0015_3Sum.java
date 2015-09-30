
public class _0015_3Sum {

/*	Given an array S of n integers, are there elements a, b, c in S such that 
 * a + b + c = 0? Find all unique triplets in the array which gives the sum of 
 * zero.

			Note:
			Elements in a triplet (a,b,c) must be in non-descending order. 
			(ie, a ¡Ü b ¡Ü c)
			The solution set must not contain duplicate triplets.
			    For example, given array S = {-1 0 1 2 -1 -4},

			    A solution set is:
			    (-1, 0, 1)
			    (-1, -1, 2)*/
	
	
	class Solution {
	public:

	    int search(vector<int> & num, int target, int l, int r) {
	        while (l <= r) {
	            int m = (l + r) / 2;
	            if (num[m] == target) return m;
	            else if (num[m] < target) l = m + 1;
	            else r = m - 1;
	        }
	        return -1;
	    }

	    vector<vector<int> > threeSum(vector<int> &num) {
	        vector<vector<int> > ans;
	        sort(num.begin(), num.end());
	        int lastI, lastJ, lastK;
	        lastI = lastJ = lastK = 123456789;  // to judge the duplicate triplets
	        for (int i = 0; i < num.size(); i++) {
	            if (i >= 1 && num[i] == num[i - 1]) continue;
	            for (int j = i + 1; j < num.size(); j++) {
	                int pos = search(num, 0 - num[i] - num[j], j + 1, num.size() - 1);  // search the third data
	                if (pos != -1) {
	                    if (num[i] == lastI && num[j] == lastJ && num[pos] == lastK) continue;
	                    vector<int> a;
	                    a.push_back(num[i]);
	                    a.push_back(num[j]);
	                    a.push_back(num[pos]);
	                    ans.push_back(a);
	                    lastI = num[i];
	                    lastJ = num[j];
	                    lastK = num[pos];
	                }
	            }
	        }
	        return ans;
	    }
	};
	
	
}
