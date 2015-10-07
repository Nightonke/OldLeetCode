
public class _0236_Lowest_Common_Ancestor_of_a_Binary_Tree {

/*	Given a binary tree, find the lowest common ancestor (LCA) of two given 
 *  nodes in the tree.

	According to the definition of LCA on Wikipedia: ¡°The lowest common 
	ancestor is defined between two nodes v and w as the lowest node in T that 
	has both v and w as descendants (where we allow a node to be a descendant 
	of itself).¡±

	        _______3______
	       /              \
	    ___5__          ___1__
	   /      \        /      \
	   6      _2       0       8
	         /  \
	         7   4
	For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another 
	example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of 
	itself according to the LCA definition.*/
	
	class Solution {
	public:
	    unordered_map<TreeNode *, bool> mp, mq;
	    TreeNode * tp, * tq;
	    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
	        mp.clear();
	        mq.clear();
	        TreeNode * now = root, *last = root;
	        tp = p;
	        tq = q;
	        mp[NULL] = false;
	        mq[NULL] = false;
	        while (1) {
	            if (exist(now->left, tp) && exist(now->left, tq)) {
	                now = now->left;
	            }
	            else if (exist(now->right, tp) && exist(now->right, tq)) {
	                now = now->right;
	            }
	            else {
	                return now;
	            }
	        }
	    }
	    bool exist(TreeNode * root, TreeNode * target) {
	        if (target == tp) {
	            if (mp.count(root) != 0) {
	                return mp[root];
	            }
	        }
	        else {
	            if (mq.count(root) != 0) {
	                return mq[root];
	            }
	        }
	        if (root == NULL) {
	            return false;
	        }
	        else {
	            if (root == target || exist(root->left, target) || exist(root->right, target)) {
	                if (target == tp) {
	                    mp[root] = true;
	                }
	                else {
	                    mq[root] = true;
	                }
	            }
	            else {
	                if (target == tp) {
	                    mp[root] = false;
	                }
	                else {
	                    mq[root] = false;
	                }
	            }
	        }
	        if (target == tp) {
	            return mp[root];
	        }
	        else {
	            return mq[root];
	        }
	    }
	};
	
}
