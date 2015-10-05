
public class _0124_Binary_Tree_Maximum_Path_Sum {

/*	Given a binary tree, find the maximum path sum.

	For this problem, a path is defined as any sequence of nodes from some 
	starting node to any node in the tree along the parent-child connections. 
	The path does not need to go through the root.

	For example:
	Given the below binary tree,

	       1
	      / \
	     2   3
	Return 6.*/
	
	int max(int a, int b) {
		if (a > b) return a;
		return b;
	}

	int ans;

	int maxDownSum(struct TreeNode * now) {
		if (!now) return 0;
		int l = max(0, maxDownSum(now->left));
		int r = max(0, maxDownSum(now->right));
		ans = max(ans, l + r + now->val);
		return max(l, r) + now->val;
	}

	int maxPathSum(struct TreeNode * root) {
		ans = INT_MIN;
		maxDownSum(root);
		return ans;
	}
	
}
