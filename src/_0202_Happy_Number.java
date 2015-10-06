
public class _0202_Happy_Number {

/*	Write an algorithm to determine if a number is "happy".

	A happy number is a number defined by the following process: Starting with 
	any positive integer, replace the number by the sum of the squares of its 
	digits, and repeat the process until the number equals 1 (where it will 
	stay), or it loops endlessly in a cycle which does not include 1. Those 
	numbers for which this process ends in 1 are happy numbers.

	Example: 19 is a happy number

	12 + 92 = 82
	82 + 22 = 68
	62 + 82 = 100
	12 + 02 + 02 = 1*/
	
	bool isHappy(int n) {
		int hash[20];
		memset(hash, -1, sizeof(hash));
		while (1) {
			int m = 0;
			while (n) {
				m += (n % 10) * (n % 10);
				n /= 10;
			}
			n = m;
			if (n == 1) return true;
			int p = n % 20;
			while (hash[p] != -1) {
				if (hash[p] == n) return false;
				p++;
				if (p == 20) p = 0;
			}
			hash[p] = n;
		}
	}
	
}
