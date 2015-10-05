
public class _0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

/*	Given preorder and inorder traversal of a tree, construct the binary tree.

	Note:
	You may assume that duplicates do not exist in the tree.*/
	
	class Solution {
	public:
	    TreeNode * buildTree(vector<int> &preorder, vector<int> &inorder) {
	        if (preorder.size() == 0) return NULL;
	        pre = preorder;
	        in = inorder;
	        TreeNode * newRoot;
	        makeBTreeByPreIn(&newRoot, 0, 0, pre.size() - 1);
	        return newRoot;
	    }
	    void makeBTreeByPreIn(TreeNode ** nowRoot, int posInPre, int searchS, int searchE) {
	        *nowRoot = new TreeNode(pre[posInPre]);
	        int leftTreeLength, rightTreeLength, leftS, leftE, rightS, rightE;
	        leftS = searchS;
	        rightE = searchE;
	        for (int i = searchS; i <= searchE; i++) {
	            if (in[i] == pre[posInPre]) {
	                leftE = i - 1;
	                rightS = i + 1;
	                break;
	            }
	        }
	        leftTreeLength = leftE - leftS  + 1;
	        rightTreeLength = rightE - rightS + 1;
	        if (leftTreeLength != 0) makeBTreeByPreIn(&((*nowRoot)->left), posInPre + 1, leftS, leftE);
	        if (rightTreeLength != 0) makeBTreeByPreIn(&((*nowRoot)->right), posInPre + leftTreeLength + 1, rightS, rightE);
	    }
	private:
	    vector<int> pre;
	    vector<int> in;
	};
	
}
