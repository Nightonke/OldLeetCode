
public class _0204_Count_Primes {

/*	Description:

	Count the number of prime numbers less than a non-negative number, n.*/
	
	int countPrimes(int n) {
		bool * IsPrime = (bool*)malloc(sizeof(bool) * n);
		for (int i = 0; i < n; i++) IsPrime[i] = true;
		for (int i = 2; i < n; i++) {
			if (IsPrime[i]) {
				for (int j = i + i; j < n; j += i) {
					IsPrime[j] = false;
				}
			}
		}
		int ans = 0;
		for (int i = 2; i < n; i++) if (IsPrime[i]) ans++;
		free(IsPrime);
		return ans;
	}
	
}
