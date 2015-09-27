
public class _0285_Inorder_Successor_in_BST {

//	Given a binary search tree and a node in it, find the in-order successor of
//	that node in the BST.
//	Note: If the given node has no in-order successor in the tree, return null.
	
	public class Solution {

		private int targetVal;
		
		public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	        
			targetVal = p.val;
			return inOrderTravel(root);
			
	    }
		
		public TreeNode inOrderTravel(TreeNode root) {
			// travel the whole tree in-order
			if (root == null) {
				return root;
			}
			if (targetVal >= root.val) {
				// if the current node's value is bigger than the target
				// the targetNode must be in the right side
				return inOrderTravel(root.right);
			} else {
				// otherwise the targetNode may be in the left side
				// and also, the targetNode may be the current node
				TreeNode targetTreeNodeInLeft = inOrderTravel(root.left);
				if (targetTreeNodeInLeft == null) {
					return root;
				} else {
					return targetTreeNodeInLeft;
				}
			}
		}
	}
}
