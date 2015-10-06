
public class _0150_Evaluate_Reverse_Polish_Notation {
	
	/*Evaluate the value of an arithmetic expression in Reverse Polish Notation.
	
	Valid operators are +, -, *, /. Each operand may be an integer or another expression.
	
	Some examples:
	  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6*/
	
	class Solution {
	public:
	    int evalRPN(vector<string> &tokens) {
	        vector<int> stack_int;
	        for (int i = 0; i < tokens.size(); i++) {
	            int x, y;
	            if ('0' <= tokens[i][tokens[i].size() - 1] && tokens[i][tokens[i].size() - 1] <= '9') {
	                stack_int.push_back(string_to_num(tokens[i]));
	            } else {
	                y = stack_int.back();
	                stack_int.pop_back();
	                x = stack_int.back();
	                stack_int.pop_back();
	                if (tokens[i][0] == '+') {
	                    stack_int.push_back(x + y);
	                } else if (tokens[i][0] == '-') {
	                    stack_int.push_back(x - y);
	                } else if (tokens[i][0] == '*') {
	                    stack_int.push_back(x * y);
	                } else if (tokens[i][0] == '/') {
	                    stack_int.push_back(x / y);
	                }
	            }
	        }
	        return stack_int.back();
	    }
	    int string_to_num(string input) {
	        int sum = 0;
	        int positive = 1;
	        int i = 0;
	        if (input[0] == '-') {
	            positive = -1;
	            i = 1;
	        }
	        for (; i < input.size(); i++) {
	            sum = sum * 10 + input[i] - '0';
	        }
	        return sum * positive;
	    }
	};
	
}
