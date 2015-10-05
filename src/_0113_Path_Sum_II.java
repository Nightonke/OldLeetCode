
public class _0113_Path_Sum_II {

/*	Given a binary tree and a sum, find all root-to-leaf paths where each path's 
 *  sum equals the given sum.

	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	return
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]*/
	
	/**
	 * Definition for binary tree
	 * struct TreeNode {
	 *     int val;
	 *     TreeNode *left;
	 *     TreeNode *right;
	 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
	 * };
	 */
	class Solution {
	public:
	    vector<vector<int> > pathSum(TreeNode *root, int sum) {
	        if (root == NULL) return ans;
	        nowSum = 0;
	        targetSum = sum;
	        findPathSum(root, 0);
	        return ans;
	    }
	    void findPathSum(TreeNode *nowRoot, int nowSum) {
	        trySum.push_back(nowRoot->val);
	        if (nowRoot->left == NULL && nowRoot->right == NULL) {
	            if (nowSum + nowRoot->val == targetSum) {
	                ans.push_back(trySum);
	            }
	            trySum.pop_back();
	            return;
	        }
	        if (nowRoot->left) findPathSum(nowRoot->left, nowSum + nowRoot->val);
	        if (nowRoot->right) findPathSum(nowRoot->right, nowSum + nowRoot->val);
	        trySum.pop_back();
	        return;
	    }
	    int nowSum;
	    int targetSum;
	    vector<int> trySum;
	    vector<vector<int> > ans;
	};
	
}
