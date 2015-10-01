
public class _0020_Valid_Parentheses {

/*	Given a string containing just the characters '(', ')', '{', '}', 
 *  '[' and ']', determine if the input string is valid.

	The brackets must close in the correct order, "()" and "()[]{}" are all 
	valid but "(]" and "([)]" are not.*/
	
	class Solution {
	public:
	    bool isValid(string s) {
	        stack<char> st;
	        for (int i = 0; i < s.size(); i++) {
	            if (st.empty()) st.push(s[i]);
	            else if (0 < s[i] - st.top() && s[i] - st.top() < 3) st.pop();
	            else st.push(s[i]);
	        }
	        return st.empty();
	    }
	};
	
}
