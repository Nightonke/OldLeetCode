
public class _0199_Binary_Tree_Right_Side_View {

/*	Given a binary tree, imagine yourself standing on the right side of it, 
 *  return the values of the nodes you can see ordered from top to bottom.

	For example:
	Given the following binary tree,
	   1            <---
	 /   \
	2     3         <---
	 \     \
	  5     4       <---
	You should return [1, 3, 4].*/
	
	class Solution {
	public:
		int depth;
		vector<int> ans;
		vector<int> rightSideView(TreeNode * root) {
			depth = -1;
			ans.clear();
			RL(root, 0);
			return ans;
		}
		void RL(TreeNode * now, int nowDepth) {
			if (!now) return;
			if (nowDepth > depth) ans.push_back(now->val), depth = nowDepth;
			RL(now->right, nowDepth + 1);
			RL(now->left, nowDepth + 1);
		}
	};
	
}
