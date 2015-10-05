
public class _0100_Same_Tree {

/*	Given two binary trees, write a function to check if they are equal or not.

	Two binary trees are considered equal if they are structurally identical and 
	the nodes have the same value.*/
	
	class Solution {
	public:
	    bool isSameTree(TreeNode *p, TreeNode *q) {
	        isSame = true;
	        if (p && q) gogogo(p, q);
	        if ((!p && q) || (p && !q)) return false;
	        return isSame;
	    }
	    void gogogo(TreeNode *nowP, TreeNode *nowQ) {
	        if (!isSame || nowP->val != nowQ->val) {
	            isSame = false;
	            return;
	        } else if ((nowP->left && !nowQ->left) || (nowP->right && !nowQ->right) || (!nowP->left && nowQ->left) || (!nowP->right && nowQ->right)) {
	            isSame = false;
	            return;
	        } else {
	            if (nowP->left) gogogo(nowP->left, nowQ->left);
	            if (nowQ->right) gogogo(nowP->right, nowQ->right);
	        }
	    }
	    bool isSame;
	};
	
}
