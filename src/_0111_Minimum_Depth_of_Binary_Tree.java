
public class _0111_Minimum_Depth_of_Binary_Tree {

/*	Given a binary tree, find its minimum depth.

	The minimum depth is the number of nodes along the shortest path from the 
	root node down to the nearest leaf node.*/
	
	class Solution {
	public:
	    int minDepth(TreeNode *root) {
	        if (!root) return 0;
	        min = 99999999;
	        now = 0;
	        if (root != NULL) gogogo(root);
	        return min;
	    }
	    void gogogo(TreeNode *nowRoot) {
	        now++;
	        if (now > min) {
	            now--;
	            return;
	        }
	        if (nowRoot->left != NULL) gogogo(nowRoot->left);
	        if (nowRoot->right != NULL) gogogo(nowRoot->right);
	        if (nowRoot->left == NULL && nowRoot->right == NULL) min = min > now ? now : min;
	        now--;
	    }
	    int now;
	    int min;
	};
	
}
