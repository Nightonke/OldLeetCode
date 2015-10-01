
public class _0050_Pow_x__n_ {

/*	Implement pow(x, n).*/
	
	class Solution {
	public:
	    double pow(double x, int n) {
	        if (n < 0) {
	            x = 1 / x;
	            n = -n;
	        }
	        if (n == 1) return x;
	        if (n == 0) return 1.0;
	        
	        if (n & 1 == 1) {
	            return x * pow(x, n - 1);
	        } else {
	            double temp = pow(x, n / 2);
	            return temp * temp;
	        }
	    }
	};
	
}
