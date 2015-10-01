
public class _0022_Generate_Parentheses {

/*	Given n pairs of parentheses, write a function to generate all 
 * combinations of well-formed parentheses.

	For example, given n = 3, a solution set is:

	"((()))", "(()())", "(())()", "()(())", "()()()"*/
	
	class Solution {
	public:
	    vector<string> generateParenthesis(int n) {
	        ans.clear();
	        anAns.clear();
	        numPair = n;
	        makeParentheses(0, 0);
	        return ans;
	    }
	    void makeParentheses(int numL, int numR) {
	        if (numR == numPair) {
	            ans.push_back(anAns);
	            return;
	        }
	        if (numL < numPair) {
	            anAns.push_back('(');
	            makeParentheses(numL + 1, numR);
	            anAns.pop_back();
	        }
	        if (numR < numL) {
	            anAns.push_back(')');
	            makeParentheses(numL, numR + 1);
	            anAns.pop_back();
	        }
	    }
	private:
	    string anAns;
	    vector<string> ans;
	    int numPair;
	};
}
