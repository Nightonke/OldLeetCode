
public class _0094_Binary_Tree_Inorder_Traversal {

/*	Given a binary tree, return the inorder traversal of its nodes' values.

	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [1,3,2].

	Note: Recursive solution is trivial, could you do it iteratively?*/
	
	class Solution {
	public:
	    vector<int> inorderTraversal(TreeNode *root) {
	        ans.clear();
	        if (root != NULL) gogogo(root);
	        return ans;
	    }
	    void gogogo(TreeNode *nowRoot) {
	        if (nowRoot->left != NULL) gogogo(nowRoot->left);
	        ans.push_back(nowRoot->val);
	        if (nowRoot->right != NULL) gogogo(nowRoot->right);
	        
	    }
	    vector<int> ans;
	};
	
}
