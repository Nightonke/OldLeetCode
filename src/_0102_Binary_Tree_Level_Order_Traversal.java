
public class _0102_Binary_Tree_Level_Order_Traversal {

/*	Given a binary tree, return the level order traversal of its nodes' values. 
 *  (ie, from left to right, level by level).

	For example:
	Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its level order traversal as:
	[
	  [3],
	  [9,20],
	  [15,7]
	]*/
	
	class Solution {
	public:
	    vector<vector<int> > levelOrder(TreeNode *root) {
	        ans.clear();
	        if (root == NULL) return ans;
	        travel(root, 0);
	        return ans;
	    }
	    vector<vector<int> > ans;
	    void travel(TreeNode * now, int level) {

	        if (level < ans.size()) {
	            ans[level].push_back(now->val);
	        } else {
	            vector<int> v;
	            v.push_back(now->val);
	            ans.push_back(v);
	        }

	        if (now->left != NULL) travel(now->left, level + 1);
	        if (now->right != NULL) travel(now->right, level + 1);

	    }
	};
	
}
