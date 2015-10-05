
public class _0095_Unique_Binary_Search_Trees_II {

/*	Given n, generate all structurally unique BST's (binary search trees) that 
 *  store values 1...n.

	For example,
	Given n = 3, your program should return all 5 unique BST's shown below.

	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
	confused what "{1,#,2,3}" means? > read more on how binary tree is 
	serialized on OJ.*/
	
	class Solution {
	public:
		vector<TreeNode *> generateTrees(int n) {
			vector<vector<TreeNode *> > dp(n + 1);
			dp[0].push_back(NULL);
			for (int len = 1; len <= n; len++) {
				for (int j = 0; j < len; j++) {
					for (int k1 = 0; k1 < dp[j].size(); k1++) {
						for (int k2 = 0; k2 < dp[len - j - 1].size(); k2++) {
							TreeNode * nodeL = dp[j][k1];
							TreeNode * nodeR = dp[len - j - 1][k2];
							TreeNode * node = new TreeNode(j + 1);
							node->left = nodeL;
							node->right = clone(nodeR, j + 1);
							dp[len].push_back(node);
						}
					}
				}
			}
			return dp[n];
		}
		TreeNode * clone(TreeNode * n, int offset) {
			if (!n) return NULL;
			TreeNode * node = new TreeNode(n->val + offset);
			node->left = clone(n->left, offset);
			node->right = clone(n->right, offset);
			return node;
		}
	};
	
}
