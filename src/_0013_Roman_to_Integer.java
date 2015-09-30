
public class _0013_Roman_to_Integer {

/*	Given a roman numeral, convert it to an integer.

	Input is guaranteed to be within the range from 1 to 3999.*/
	
	class Solution {
	public:
	    Solution() {
	        R2I['\0'] = 0;
	        R2I['I'] = 1;
	        R2I['V'] = 5;
	        R2I['X'] = 10;
	        R2I['L'] = 50;
	        R2I['C'] = 100;
	        R2I['D'] = 500;
	        R2I['M'] = 1000;
	    }
	    int romanToInt(string s) {
	        int ans = 0;
	        for (int i = 0; i < s.length(); ) {
	            if (i < s.length() - 1 && R2I[s[i]] < R2I[s[i + 1]]) {
	                ans += R2I[s[i + 1]] - R2I[s[i]];
	                i += 2;
	            } else {
	                ans += R2I[s[i]];
	                i++;
	            }
	        }
	        return ans;
	    }
	private:
	    map<char, int> R2I;
	};
	
}
