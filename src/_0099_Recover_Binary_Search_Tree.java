
public class _0099_Recover_Binary_Search_Tree {

/*	Two elements of a binary search tree (BST) are swapped by mistake.

	Recover the tree without changing its structure.

	Note:
	A solution using O(n) space is pretty straight forward. Could you devise a 
	constant space solution?*/
	
	class Solution {
	public:
	    TreeNode * current, * last, * t1, * t2, * t3, * t4;
	    bool first;
	    void recoverTree(TreeNode *root) {
	        current = last = t1 = t2 = t3 = t4 = NULL;
	        first = true;
	        inOrderTravel(root);
	        if (t3 == NULL && t1) swap(t1->val, t2->val);
	        if (t3 && t1) swap(t1->val, t4->val);
	    }
	    void inOrderTravel(TreeNode * now) {

	        if (now->left) inOrderTravel(now->left);

	        last = current;
	        current = now;

	        if (last && current && last->val > current->val) {
	            if (first) {
	                t1 = last;
	                t2 = current;
	                first = false;
	            } else {
	                t3 = last;
	                t4 = current;
	            }
	        }

	        if (now->right) inOrderTravel(now->right);

	    }
	};
	
}
