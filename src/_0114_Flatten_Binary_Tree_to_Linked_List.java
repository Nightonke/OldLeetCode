
public class _0114_Flatten_Binary_Tree_to_Linked_List {

/*	Given a binary tree, flatten it to a linked list in-place.

	For example,
	Given

	         1
	        / \
	       2   5
	      / \   \
	     3   4   6
	The flattened tree should look like:
	   1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6*/
	
	class Solution {
	public:
	    void flatten(TreeNode *root) {
	        if (!root) return;
	        TreeNode *temp;
	        stack<TreeNode*> st;
	        st.push(root);
	        while (!st.empty()) {
	            temp = st.top(), st.pop();
	            if (!temp->left && !temp->right && !st.empty()) {
	                temp->right = st.top();
	                continue;
	            }
	            if (temp->right) st.push(temp->right);
	            if (temp->left) {
	                st.push(temp->left);
	                temp->right = temp->left;
	                temp->left = NULL;
	            }
	        }
	    }
	};
	
}
