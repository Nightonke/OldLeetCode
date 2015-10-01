
public class _0032_Longest_Valid_Parentheses {

/*	Given a string containing just the characters '(' and ')', find the length 
 *  of the longest valid (well-formed) parentheses substring.

	For "(()", the longest valid parentheses substring is "()", which has 
	length = 2.

	Another example is ")()())", where the longest valid parentheses substring 
	is "()()", which has length = 4.*/
	
	class Solution {
	public:
	    int longestValidParentheses(string s) {
	        stack<int> st;
	        for (int i = 0; i < s.length(); i++) {
	            if (st.empty()) {
	                st.push(i);
	            } else {
	                if (s[i] == '(') {
	                    st.push(i);
	                } else {
	                    if (s[st.top()] == '(') {
	                        st.pop();
	                    } else {
	                        st.push(i);
	                    }
	                }
	            }
	        }
	        if (st.empty()) {
	            return s.length();
	        } else {
	            vector<int> v;
	            v.push_back(s.length());
	            while (!st.empty()) {
	                v.push_back(st.top());
	                st.pop();
	            }
	            v.push_back(-1);
	            int max = -1;
	            for (int i = 0; i < v.size() - 1; i++) {
	                if (v[i] - v[i + 1] - 1 > max) max = v[i] - v[i + 1] - 1;
	            }
	            return max;
	        }
	    }
	};
	
}
