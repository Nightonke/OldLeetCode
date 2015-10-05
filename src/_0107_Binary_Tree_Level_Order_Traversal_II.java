
public class _0107_Binary_Tree_Level_Order_Traversal_II {

/*	Given a binary tree, return the bottom-up level order traversal of its 
 *  nodes' values. (ie, from left to right, level by level from leaf to root).

	For example:
	Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its bottom-up level order traversal as:
	[
	  [15,7],
	  [9,20],
	  [3]
	]*/
	
	class Solution {
	public:
	    vector<vector<int> > levelOrderBottom(TreeNode *root) {
	        ans.clear();
	        if (root == NULL) return ans;
	        travel(root, 0);
	        reverse(ans.begin(), ans.end());
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
