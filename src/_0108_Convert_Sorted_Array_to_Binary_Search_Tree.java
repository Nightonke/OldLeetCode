
public class _0108_Convert_Sorted_Array_to_Binary_Search_Tree {

/*	Given an array where elements are sorted in ascending order, convert it to 
 *  a height balanced BST.*/
	
	class Solution {
	public:
	    vector<int> Num;
	    TreeNode *sortedArrayToBST(vector<int> &num) {
	        if (num.size() == 0) return NULL;
	        Num = num;
	        return make(0, Num.size() - 1);
	    }
	    TreeNode * make(int l, int r) {
	        int mid = (l + r) / 2;
	        TreeNode * newRoot = new TreeNode(Num[mid]);
	        if (l < mid) newRoot->left = make(l, mid - 1);
	        if (mid < r) newRoot->right = make(mid + 1, r);
	        return newRoot;
	    }
	};
	
}
