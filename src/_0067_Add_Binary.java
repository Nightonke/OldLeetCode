
public class _0067_Add_Binary {

/*	Given two binary strings, return their sum (also a binary string).

	For example,
	a = "11"
	b = "1"
	Return "100".*/
	
	class Solution {
	public:
	    string addBinary(string a, string b) {
	        reverse(a.begin(), a.end());
	        reverse(b.begin(), b.end());
	        if (a.size() < b.size()) swap(a, b);
	        b.append(a.size() - b.size(), '0');
	        string ans(a.size() + 2, '0');
	        for (int i = 0; i < a.size(); i++) {
	            ans[i + 1] += ((ans[i] - '0') + (a[i] - '0') + (b[i] - '0')) / 2;
	            ans[i] = ((ans[i] - '0') + (a[i] - '0') + (b[i] - '0')) % 2 + '0';            
	        }
	        int i;
	        for (i = ans.size() - 1; i > 0 && ans[i] == '0'; i--);
	        ans = ans.substr(0, i + 1);
	        reverse(ans.begin(), ans.end());
	        return ans;
	    }
	};
	
}
