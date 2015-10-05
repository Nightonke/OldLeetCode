
public class _0112_Path_Sum {

/*	Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
 *  such that adding up all the values along the path equals the given sum.

	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \      \
	        7    2      1
	return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	*/
	
	class Solution {
	public:
	    bool hasPathSum(TreeNode *root, int sum) {
	        if (root == NULL) return false;
	        bingo = false;
	        nowSum = 0;
	        targetSum = sum;
	        findPathSum(root, 0);
	        return bingo;
	    }
	    void findPathSum(TreeNode *nowRoot, int nowSum) {
	        if (nowRoot->left == NULL && nowRoot->right == NULL) {
	            if (nowSum + nowRoot->val == targetSum) {
	                bingo = true;
	            }
	            return;
	        }
	        if (nowRoot->left && !bingo) findPathSum(nowRoot->left, nowSum + nowRoot->val);
	        if (nowRoot->right && !bingo) findPathSum(nowRoot->right, nowSum + nowRoot->val);
	        return;
	    }
	    int nowSum;
	    int targetSum;
	    bool bingo;
	};
	
}
