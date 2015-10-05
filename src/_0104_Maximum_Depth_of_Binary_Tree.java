
public class _0104_Maximum_Depth_of_Binary_Tree {

/*	Given a binary tree, find its maximum depth.

	The maximum depth is the number of nodes along the longest path from the 
	root node down to the farthest leaf node.*/
	
	class Solution {
	public:
	    int maxDepth(TreeNode *root) {
	        max = 0;
	        now = 0;
	        if (root != NULL) gogogo(root);
	        return max;
	    }
	    void gogogo(TreeNode *nowRoot) {
	        now++;
	        if (nowRoot->left != NULL) gogogo(nowRoot->left);
	        if (nowRoot->right != NULL) gogogo(nowRoot->right);
	        if (nowRoot->left == NULL && nowRoot->right == NULL) max = max > now ? max : now;
	        now--;
	    }
	    int now;
	    int max;
	};
	
}
