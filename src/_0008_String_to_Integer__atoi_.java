
public class _0008_String_to_Integer__atoi_ {

/*	Implement atoi to convert a string to an integer.

	Hint: Carefully consider all possible input cases. If you want a challenge, 
	please do not see below and ask yourself what are the possible input cases.

	Notes: It is intended for this problem to be specified vaguely (ie, no given 
	input specs). You are responsible to gather all the input requirements up 
	front.

	Update (2015-02-10):
	The signature of the C++ function had been updated. If you still see your 
	function signature accepts a const char * argument, please click the reload 
	button  to reset your code definition.*/
	
	class Solution {
	public:
	    int atoi(const char *str) {
	        int p = 1;
	        int i = 0;
	        while (str[i] == ' ') i++;  // ignore the leading blank
	        if (str[i] != '+' && str[i] != '-' && (str[i] < '0' || str[i] > '9')) return 0;  // if the first character is not valid
	        if (str[i] == '+' || str[i] == '-') {
	            if (str[i] == '-') p = -1;
	            i++;
	            if (str[i] < '0' || str[i] > '9') return 0;  // if the first character after the plus or minus sign is invalid
	        }
	        string num;
	        while ('0' <= str[i] && str[i] <= '9') {
	            num.push_back(str[i++]);
	        }
	        if (num.size() > 10) return (p == 1 ? 2147483647 : -2147483648);
	        if (num.size() == 10) {
	            if (p == 1 && num >= "2147483647") return 2147483647;
	            if (p == -1 && num >= "2147483648") return -2147483648;
	        }
	        int ans = 0;
	        for (int i = 0; i < num.size(); i++) {
	            ans = ans * 10 + num[i] - '0';
	        }
	        return p * ans;
	    }
	};
	
}
