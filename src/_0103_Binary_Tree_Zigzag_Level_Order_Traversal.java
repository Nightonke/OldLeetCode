
public class _0103_Binary_Tree_Zigzag_Level_Order_Traversal {

/*	Given a binary tree, return the zigzag level order traversal of its nodes' 
 *  values. (ie, from left to right, then right to left for the next level and 
 *  alternate between).

	For example:
	Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]*/
	
	class Solution {
	public:
	    vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
	        ans.clear();
	        if (root == NULL) return ans;
	        travel(root, 0);
	        for (int i = 0; i < ans.size(); i++) {
	            if (i % 2) reverse(ans[i].begin(), ans[i].end());
	        }
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
