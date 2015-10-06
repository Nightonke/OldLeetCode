
public class _0166_Fraction_to_Recurring_Decimal {

/*	Given two integers representing the numerator and denominator of a fraction, 
 *  return the fraction in string format.

	If the fractional part is repeating, enclose the repeating part in 
	parentheses.

	For example,

	Given numerator = 1, denominator = 2, return "0.5".
	Given numerator = 2, denominator = 1, return "2".
	Given numerator = 2, denominator = 3, return "0.(6)".*/
	
	class Solution {
	public:
	    string fractionToDecimal(long long n, long long d) {
	        if (n == 0) return "0";
	        string ans;
	        if (n < 0 ^ d < 0) ans += "-";
	        n = abs(n);
	        d = abs(d);
	        ans += to_string(n / d);
	        if (n % d == 0) return ans;
	        ans += ".";
	        map<int, int> m;
	        for(long long r = n % d; r; r %= d) {
	            if (m.count(r)) {
	                ans.insert(m[r], 1, '(');
	                ans += ')';
	                return ans;
	            }
	            m[r] = ans.size();
	            r *= 10;
	            ans += to_string(r / d);
	        }
	        return ans;
	    }
	};
	
}
