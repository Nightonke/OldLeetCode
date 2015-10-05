
public class _0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

/*	Given inorder and postorder traversal of a tree, construct the binary tree.

	Note:
	You may assume that duplicates do not exist in the tree.*/
	
	class Solution {
	public:
	    TreeNode * buildTree( vector<int> &inorder, vector<int> &postorder) {
	        if (postorder.size() == 0) return NULL;
	        post = postorder;
	        in = inorder;
	        TreeNode * newRoot;
	        makeBTreeByPreIn(&newRoot, post.size() - 1, 0, post.size() - 1);
	        return newRoot;
	    }
	    void makeBTreeByPreIn(TreeNode ** nowRoot, int posInPost, int searchS, int searchE) {
	        *nowRoot = new TreeNode(post[posInPost]);
	        int leftTreeLength, rightTreeLength, leftS, leftE, rightS, rightE;
	        leftS = searchS;
	        rightE = searchE;
	        for (int i = searchS; i <= searchE; i++) {  // find the nowRoot's data in searching range of the inorder vector
	            if (in[i] == post[posInPost]) {
	                leftE = i - 1;
	                rightS = i + 1;
	                break;
	            }
	        }
	        leftTreeLength = leftE - leftS  + 1;
	        rightTreeLength = rightE - rightS + 1;
	        if (leftTreeLength != 0) makeBTreeByPreIn(&((*nowRoot)->left), posInPost - rightTreeLength - 1, leftS, leftE);
	        if (rightTreeLength != 0) makeBTreeByPreIn(&((*nowRoot)->right), posInPost - 1, rightS, rightE);
	    }
	private:
	    vector<int> post;
	    vector<int> in;
	};
	
}
