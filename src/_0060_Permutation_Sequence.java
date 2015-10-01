
public class _0060_Permutation_Sequence {

/*	The set [1,2,3,бн,n] contains a total of n! unique permutations.

	By listing and labeling all of the permutations in order,
	We get the following sequence (ie, for n = 3):

	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	Given n and k, return the kth permutation sequence.

	Note: Given n will be between 1 and 9 inclusive.*/
	
	class Solution {
	public:
	    string getPermutation(int n, int k) {

	        string ans;

	        int * a = new int[n];
	        for (int i = 0; i < n; i++) a[i] = i + 1;

	        int fac = 1;
	        for (int i = 2; i < n; i++) fac *= i;
	        k--;

	        bool * used = new bool[n + 1];
	        for (int i = 1; i <= n; i++) used[i] = false;

	        for (int i = n - 1; i >= 1; i--) {

	            int num = k / fac;
	            k %= fac;
	            fac /= i;
	            int lessNum = 0;
	            int nextNum = 1;

	            for (; nextNum <= n && lessNum < num; nextNum++) {
	                if (!used[nextNum]) {
	                    lessNum++;
	                }
	            }
	            while (used[nextNum]) nextNum++;

	            used[nextNum] = true;
	            ans.push_back(nextNum + '0');

	        }

	        for (int i = 1; i <= n; i++) {
	            if (!used[i]) {
	                ans.push_back(i + '0');
	                break;
	            }
	        }

	        return ans;
	    }
	};

}
