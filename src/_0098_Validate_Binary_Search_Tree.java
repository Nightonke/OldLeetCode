
public class _0098_Validate_Binary_Search_Tree {

/*	Given a binary tree, determine if it is a valid binary search tree (BST).

	Assume a BST is defined as follows:

	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.*/
	
	class Solution {
	public:
	    int last;
	    bool isValid;
	    bool begin;
	    bool isValidBST(TreeNode *root) {
	        if (root == NULL) return true;
	        isValid = true;
	        begin = true;
	        midtravel(root);
	        return isValid;
	    }
	    void midtravel(TreeNode * now) {
	        if (now->left != NULL) midtravel(now->left);
	        if (begin || last < now->val) {
	            last = now->val;
	            begin = false;
	        } else {
	            isValid = false;
	            return;
	        }
	        if (now->right != NULL) midtravel(now->right);
	    }
	};
	
}
