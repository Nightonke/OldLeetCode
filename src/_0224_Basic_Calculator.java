
public class _0224_Basic_Calculator {

/*	Implement a basic calculator to evaluate a simple expression string.

	The expression string may contain open ( and closing parentheses ), the 
	plus + or minus sign -, non-negative integers and empty spaces .

	You may assume that the given expression is always valid.

	Some examples:
	"1 + 1" = 2
	" 2-1 + 2 " = 3
	"(1+(4+5+2)-3)+(6+8)" = 23*/
	
	class ExpressionTransformation {
	public:
	    string trans_to_postfix_expression_to_s(string);  // 将得到的表达式转化为后缀表达式
	    long long int calculate_from_postfix_expression();  // 根据后缀表达式计算值

	private:
	    vector<string> ans_vector_post;  // 存放后缀表达式
	    string post_string;  // 存放后缀表达式
	};

	inline int prior(char op) {  // 计算优先级函数
	    if (op == '+' || op == '-') {
	        return 1;
	    }
	    else if (op == '*' || op == '/' || op == '%') {
	        return 2;
	    }
	    else {
	        return 0;
	    }
	}

	long long int string_to_int(string in) {  // 将输入的字符串转化为相应数字函数
	    char s[50];
	    for (int i = 0; i < 50; i++) {
	        s[i] = '\0';
	    }
	    for (int i = 0; i < in.size(); i++) {
	        s[i] = in[i];
	    }
	    long long int ans;
	    sscanf(s, "%lld", &ans);
	    return ans;
	}

	string deleteBlank(string in) {
	    string ans;
	    int size = in.size();
	    for (int i = 0; i < size; i++) {
	        if (in[i] != ' ') ans.push_back(in[i]);
	    }
	    return ans;
	}

	string ExpressionTransformation::trans_to_postfix_expression_to_s(string in) {

	    stack<char> op;  // 操作符栈
	    ans_vector_post.clear();  // 后缀表达式存放数组
	    for (int i = 0; i < in.size();) {
	        char c = in[i];
	        if ('0' <= c && c <= '9') {  // 是数字直接插入
	            string num;
	            int j;
	            for (j = i; j < in.size() && '0' <= in[j] && in[j] <= '9'; j++) {
	                num.push_back(in[j]);
	            }
	            ans_vector_post.push_back(num);
	            i = j;
	        }
	        else {
	            if (c == '(') {  // 是开括号直接插入
	                op.push('(');
	            }
	            else {
	                if (c == ')') {  // 是闭括号就把原本栈中的运算符都输出，直到遇到开括号，注意开括号要丢弃
	                    while (op.top() != '(') {
	                        string temp;
	                        temp.push_back(op.top());
	                        ans_vector_post.push_back(temp);
	                        op.pop();
	                    }
	                    op.pop();
	                }
	                else {  // 假如是加减乘除取余
	                    if (op.empty()) {  // 操作符栈是空就直接插入
	                        op.push(c);
	                    }
	                    else {  // 如果扫描到的运算符优先级高于栈顶运算符则，把运算符压入栈。否则的话，就依次把栈中运算符弹出加到数组ans的末尾，直到遇到优先级低于扫描到的运算符或栈空，并且把扫描到的运算符压入栈中
	                        if (prior(c) > prior(op.top())) {
	                            op.push(c);
	                        }
	                        else {
	                            while (!op.empty() && prior(c) <= prior(op.top())) {
	                                string temp;
	                                temp.push_back(op.top());
	                                ans_vector_post.push_back(temp);
	                                op.pop();
	                            }
	                            op.push(c);
	                        }
	                    }
	                }
	            }
	            i++;
	        }
	    }
	    while (!op.empty()) {  // 注意把操作符栈中的剩余操作符输出
	        string temp;
	        temp.push_back(op.top());
	        ans_vector_post.push_back(temp);
	        op.pop();
	    }

	    post_string.clear();  // 构造string并返回
	    for (int i = 0; i < ans_vector_post.size(); i++) {
	        post_string += ans_vector_post[i];
	    }

	    return post_string;
	}

	long long int ExpressionTransformation::calculate_from_postfix_expression() {

	    //利用栈对后缀表达式求值，直接从后缀表达式的左往右扫描，遇到数字放入栈中，遇到字符就把栈顶的两个数字拿出来算，然后再放进栈

	    stack<long long int> ans_post;
	    for (int i = 0; i < ans_vector_post.size(); i++) {
	        long long int x, y;
	        if ('0' <= ans_vector_post[i][0] && ans_vector_post[i][0] <= '9') {
	            ans_post.push(string_to_int(ans_vector_post[i]));
	        }
	        else {
	            y = ans_post.top();  // 注意顺序，这里好比xy+就是x+y
	            ans_post.pop();
	            x = ans_post.top();
	            ans_post.pop();
	            if (ans_vector_post[i][0] == '+') {
	                ans_post.push(x + y);
	            }
	            else if (ans_vector_post[i][0] == '-') {
	                ans_post.push(x - y);
	            }
	            else if (ans_vector_post[i][0] == '*') {
	                ans_post.push(x * y);
	            }
	            else if (ans_vector_post[i][0] == '/') {
	                ans_post.push(x / y);
	            }
	            else {
	                ans_post.push(x % y);
	            }
	        }
	    }
	    return ans_post.top();
	}

	class Solution {
	public:
	    int calculate(string s) {
	        ExpressionTransformation e;
	        s = deleteBlank(s);
	        e.trans_to_postfix_expression_to_s(s);
	        int postAns = e.calculate_from_postfix_expression();
	        return postAns;
	    }
	};
	
}
