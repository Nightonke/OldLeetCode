
public class _0161_One_Edit_Distance {

/*	Given two strings S and T, determine if they are both one edit distance 
 *  apart.*/
	
	class Solution {
	public:
	    bool isOneEditDistance(string s, string t) {
	        if (s.size() == t.size() - 1) {
	            for (int i = 0; i < t.size(); i++) {
	                string ns = t.substr(0, i) + t.substr(i + 1);
	                if (ns == s) {
	                    return true;
	                }
	            }
	        }
	        else if (s.size() == t.size() + 1) {
	            for (int i = 0; i < s.size(); i++) {
	                string ns = s.substr(0, i) + s.substr(i + 1);
	                if (ns == t) {
	                    return true;
	                }
	            }
	        }
	        else if (s.size() == t.size()) {
	            int diffNum = 0;
	            for (int i = 0; i < s.size(); i++) {
	                if (s[i] != t[i]) {
	                    diffNum++;
	                }
	            }
	            return diffNum == 1;
	        }
	        return false;
	    }
	};
	
}
