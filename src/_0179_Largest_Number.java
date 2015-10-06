
public class _0179_Largest_Number {

/*	Given a list of non negative integers, arrange them such that they form the 
 *  largest number.

	For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

	Note: The result may be very large, so you need to return a string instead 
	of an integer.*/
	
	bool cmp(const string & s1, const string & s2) {
	    return s1 + s2 < s2 + s1;
	}

	class Solution {
	public:
	    string largestNumber(vector<int> &num) {
	        vector<string> v;
	        for (int i = 0; i < num.size(); i++) v.push_back(int2str(num[i]));
	        sort(v.begin(), v.end(), cmp);
	        string ans;
	        for (int i = num.size() - 1; i >= 0; i--) ans += v[i];
	        int i = 0;
	        while (ans[i] == '0' && i != ans.size() - 1) i++;
	        return ans.substr(i, ans.size() - i);
	    }
	    string int2str(int i) {
	        string ans;
	        if (i == 0) return "0";
	        while (i) {
	            ans.push_back(i % 10 + '0');
	            i /= 10;
	        }
	        reverse(ans.begin(), ans.end());
	        return ans;
	    }
	};
	
}
