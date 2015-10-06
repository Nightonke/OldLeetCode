
public class _0156_Binary_Tree_Upside_Down {

/*	Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

	For example:
	Given a binary tree {1,2,3,4,5},
	    1
	   / \
	  2   3
	 / \
	4   5
	return the root of the binary tree [4,5,2,#,#,3,1].
	   4
	  / \
	 5   2
	    / \
	   3   1  
	  
        1              1              1 
	   / \            / \            / 
	  2   3   ->     2 - 3   ->     2 - 3
	 / \            / \            / 
	4   5          4 - 5          4 - 5     which is the answer.
   
   */
	
	class Solution {
	public:
	    TreeNode * ans;
	    TreeNode* upsideDownBinaryTree(TreeNode* root) {
	        if (root == NULL || root->left == NULL) return root;
	        changeStructure(root);
	        return ans;
	    }
	    void changeStructure(TreeNode * now) {
	        if (now->left->left == NULL) {
	            ans = now->left;
	        }
	        else {
	            changeStructure(now->left);
	        }
	        now->left->left = now->right;
	        now->left->right = now;
	        now->left = now->right = NULL;
	    }
	};

}
