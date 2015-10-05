
public class _0129_Sum_Root_to_Leaf_Numbers {

/*	Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

	An example is the root-to-leaf path 1->2->3 which represents the number 123.

	Find the total sum of all root-to-leaf numbers.

	For example,

	    1
	   / \
	  2   3
	The root-to-leaf path 1->2 represents the number 12.
	The root-to-leaf path 1->3 represents the number 13.

	Return the sum = 12 + 13 = 25.*/
	
	class Solution {
	public:
	    int sumNumbers(TreeNode *root) {
	        ans = 0;
	        if (root != NULL) gogogo(root, 0);
	        return ans;
	    }
	    void gogogo(TreeNode * nowRoot, int nowSum) {
	        if (nowRoot->left == NULL && nowRoot->right == NULL) ans += nowSum * 10 + nowRoot->val;
	        if (nowRoot->left != NULL) gogogo(nowRoot->left, nowSum * 10 + nowRoot->val);
	        if (nowRoot->right != NULL) gogogo(nowRoot->right, nowSum * 10 + nowRoot->val);
	    }
	private:
	    int ans;
	};
	
}
