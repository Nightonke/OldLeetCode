
public class _0226_Invert_Binary_Tree {

/*	Invert a binary tree.

	    4
	  /   \
	 2     7
	/ \   / \
	1   3 6   9
	to
	    4
	  /   \
	 7     2
	/ \   / \
	9   6 3   1
	Trivia:
	This problem was inspired by this original tweet by Max Howell:
	Google: 90% of our engineers use the software you wrote (Homebrew), but you 
	can¡¯t invert a binary tree on a whiteboard so fuck off.*/
	
	struct TreeNode* invertTree(struct TreeNode* root) {
	    if (root == NULL) return root;
	    invertTree(root->left);
	    invertTree(root->right);
	    struct TreeNode * temp = root->left;
	    root->left = root->right;
	    root->right = temp;
	    return root;
	}
	
}
