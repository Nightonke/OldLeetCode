
public class _0010_Regular_Expression_Matching {

/*	Implement regular expression matching with support for '.' and '*'.

	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.

	The matching should cover the entire input string (not partial).

	The function prototype should be:
	bool isMatch(const char *s, const char *p)

	Some examples:
	isMatch("aa","a") ¡ú false
	isMatch("aa","aa") ¡ú true
	isMatch("aaa","aa") ¡ú false
	isMatch("aa", "a*") ¡ú true
	isMatch("aa", ".*") ¡ú true
	isMatch("ab", ".*") ¡ú true
	isMatch("aab", "c*a*b") ¡ú true*/
	
	class Solution {
	public:
	    bool isMatch(const char *s, const char *p) {  

	        if (*p == '\0') return *s == '\0';

	        if (*(p + 1) == '*') {

	            while (*s != '\0' && (*s == *p || *p == '.')) {

	                if (isMatch(s, p + 2)) return true;
	                s++;

	            }

	            return isMatch(s, p + 2);

	        } else {

	            if (*s != '\0' && (*s == *p || *p == '.')) return isMatch(s + 1, p + 1);

	            else return false;

	        }   

	    }
	};
	
}
