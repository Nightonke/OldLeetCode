
public class _0230_Kth_Smallest_Element_in_a_BST {

/*	Given a binary search tree, write a function kthSmallest to find the kth 
 *  smallest element in it.

	Note: 
	You may assume k is always valid, 1 ¡Ü k ¡Ü BST's total elements.

	Follow up:
	What if the BST is modified (insert/delete operations) often and you need to 
	find the kth smallest frequently? How would you optimize the kthSmallest 
	routine?*/
	
	class Solution {
	public:
	    int kthSmallest(TreeNode* root, int k) {
	        int count = countNodes(root->left);
	        if (k <= count) {
	            return kthSmallest(root->left, k);
	        }
	        else if (k > count + 1) {
	            return kthSmallest(root->right, k - count - 1);
	        }
	        else {
	            return root->val;
	        }
	    }
	    int countNodes(TreeNode * root) {
	        if (root != NULL) {
	            return 1 + countNodes(root->left) + countNodes(root->right);
	        }
	        else {
	            return 0;
	        }
	    }
	};
	
}
