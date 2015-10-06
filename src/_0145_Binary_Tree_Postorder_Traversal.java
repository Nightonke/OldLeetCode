
public class _0145_Binary_Tree_Postorder_Traversal {

/*	Given a binary tree, return the postorder traversal of its nodes' values.

	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [3,2,1].

	Note: Recursive solution is trivial, could you do it iteratively?*/
	
	class Solution {
	public:
	    vector<int> postorderTraversal(TreeNode *root) {
	        ans.clear();
	        if (root != NULL) gogogo(root);
	        return ans;
	    }
	    void gogogo(TreeNode *nowRoot) {
	        if (nowRoot->left != NULL) gogogo(nowRoot->left);
	        if (nowRoot->right != NULL) gogogo(nowRoot->right);
	        ans.push_back(nowRoot->val);
	    }
	    vector<int> ans;
	};
	
}
