
public class _0144_Binary_Tree_Preorder_Traversal {

/*	Given a binary tree, return the preorder traversal of its nodes' values.

	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [1,2,3].

	Note: Recursive solution is trivial, could you do it iteratively?*/
	
	class Solution {
	public:
	    vector<int> preorderTraversal(TreeNode *root) {
	        ans.clear();
	        if (root != NULL) gogogo(root);
	        return ans;
	    }
	    void gogogo(TreeNode *nowRoot) {
	        ans.push_back(nowRoot->val);
	        if (nowRoot->left != NULL) gogogo(nowRoot->left);
	        if (nowRoot->right != NULL) gogogo(nowRoot->right);
	        
	    }
	    vector<int> ans;
	};
	
}
