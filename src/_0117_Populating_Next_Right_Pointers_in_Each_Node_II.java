
public class _0117_Populating_Next_Right_Pointers_in_Each_Node_II {

/*	Follow up for problem "Populating Next Right Pointers in Each Node".

	What if the given tree could be any binary tree? Would your previous solution still work?

	Note:

	You may only use constant extra space.
	For example,
	Given the following binary tree,
	         1
	       /  \
	      2    3
	     / \    \
	    4   5    7
	After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \    \
	    4-> 5 -> 7 -> NULL*/
	
	class Solution {
	  public:
	    void connect(TreeLinkNode *root) {
	        if (root == NULL) return;
	        Node.clear();
	        GoAndConnect(root, 0);
	    }
	    void GoAndConnect(TreeLinkNode * nowRoot, int nowLevel) {
	        if (nowLevel >= Node.size()) {
	            Node.push_back(nowRoot);
	        } else {
	            Node[nowLevel]->next = nowRoot;
	            Node[nowLevel] = nowRoot;
	        }
	        if (nowRoot->left) GoAndConnect(nowRoot->left, nowLevel + 1);
	        
	        if (nowRoot->right) GoAndConnect(nowRoot->right, nowLevel + 1);
	    }
	  private:
	      vector<TreeLinkNode *> Node;
	};
	
}
