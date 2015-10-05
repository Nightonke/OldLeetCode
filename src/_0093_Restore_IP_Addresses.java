
public class _0093_Restore_IP_Addresses {

/*	Given a string containing only digits, restore it by returning all possible 
 *  valid IP address combinations.

	For example:
	Given "25525511135",

	return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)*/
	
	class Solution {
	public:
	    vector<string> restoreIpAddresses(string s) {
	        vector<string> ans;
	        for (int i = 1; i < s.size() && i < 4; i++) {
	            for (int j = i + 1; j < s.size() && j < i + 4; j++) {
	                for (int k = j + 1; k < s.size() && k < j + 4; k++) {
	                    string newS = s.substr(0, i) + "." + s.substr(i, j - i) + "." + s.substr(j, k - j) + "." + s.substr(k, s.size() - k);
	                    if (judgeString(newS)) ans.push_back(newS);
	                }
	            }
	        }
	        return ans;
	    }
	    bool judgeString(string in) {
	        in = "." + in + ".";
	        for (int i = 0; i < in.size();) {
	            if (in[i] == '.') {
	                int j = i + 1;
	                if (j == in.size()) return true;
	                for (; in[j] != '.'; j++);
	                string inNum = in.substr(i + 1, j - 1 - i);
	                if (!judgeNum(inNum)) return false;
	                i = j;
	            } else {
	                i++;
	            }
	        }
	        return true;
	    }
	    bool judgeNum(string in) {
	        if ((in.size() > 1 && in[0] == '0') || in.size() == 0 || (in.size() == 3 && in > "255") || (in.size() > 3)) return false;
	        return true;
	    }
	};
	
}
