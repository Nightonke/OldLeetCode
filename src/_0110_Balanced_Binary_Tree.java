
public class _0110_Balanced_Binary_Tree {
	
/*	Given a binary tree, determine if it is height-balanced.

	For this problem, a height-balanced binary tree is defined as a binary tree 
	in which the depth of the two subtrees of every node never differ by more 
	than 1.*/
	
	class Solution {
	public:
	    bool isBalanced(TreeNode *root) {
	        if (root == NULL) return true;
	        isBalancedTree = true;
	        dfs(root, 0);
	        return isBalancedTree;
	    }
	    int dfs(TreeNode * now, int d) {

	        int ld = 0, rd = 0;

	        if (now->left != NULL && isBalancedTree) ld = dfs(now->left, 0);
	        if (now->right != NULL && isBalancedTree) rd = dfs(now->right, 0);

	        if (abs(ld - rd) > 1) isBalancedTree = false;

	        return max(ld, rd) + 1;

	    }
	    bool isBalancedTree;
	};
	
}
