
public class _0096_Unique_Binary_Search_Trees {

/*	Given n, how many structurally unique BST's (binary search trees) that store 
 *  values 1...n?

	For example,
	Given n = 3, there are a total of 5 unique BST's.

	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3*/
	
	class Solution {
	public:
	    Solution() {
	        for (int i = 0; i < 100; ans[i++] = 0);
	        ans[0] = ans[1] = 1;
	    }
	    int numTrees(int n) {
	        return cal(n);
	    }
	    int cal(int n) {
	        if (ans[n]) return ans[n];
	        for (int i = 0; i < n; i++) {
	            ans[n] += cal(i) * cal(n - 1 - i);
	        }
	        return ans[n];
	    }
	    int ans[100];
	};

	
}
