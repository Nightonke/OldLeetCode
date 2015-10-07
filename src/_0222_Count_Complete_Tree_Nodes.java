
public class _0222_Count_Complete_Tree_Nodes {

/*	Given a complete binary tree, count the number of nodes.

	Definition of a complete binary tree from Wikipedia:
	In a complete binary tree every level, except possibly the last, is 
	completely filled, and all nodes in the last level are as far left as 
	possible. It can have between 1 and 2h nodes inclusive at the last 
	level h.*/

	int maxD, num;

	int calDeepFromRight(struct TreeNode* root) {
	    int ans = 0;
	    while (root) {
	        ans++;
	        root = root->right;
	    }
	    return ans;
	}

	int calDeepFromLeft(struct TreeNode* root) {
	    int ans = 0;
	    while (root) {
	        ans++;
	        root = root->left;
	    }
	    return ans;
	}

	void findBreakPoint(struct TreeNode* root, int pos, int deep) {
	    if (num != -1) return;
	    if (root == NULL && deep == maxD) {
	        num = 1;
	        int base = 1;
	        for (int i = 1; i < deep - 1; i++) num += (base *= 2);
	        num += pos;
	        return;
	    }
	    else {
	        if (root == NULL) return;
	        findBreakPoint(root->left, pos * 2, deep + 1);
	        findBreakPoint(root->right, pos * 2 + 1, deep + 1);
	    }
	}

	int countNodes(struct TreeNode* root) {
	    int ld = calDeepFromLeft(root), rd = calDeepFromRight(root);
	    maxD = ld;
	    if (ld == rd) {
	        if (ld == 0) return 0;
	        int base = 1;
	        num = 1;
	        for (int i = 1; i < ld; i++) num += (base *= 2);
	    }
	    else {
	        num = -1;
	        findBreakPoint(root, 0, 1);
	    }
	    return num;
	}
	
}
