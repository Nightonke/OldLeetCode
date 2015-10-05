
public class _0109_Convert_Sorted_List_to_Binary_Search_Tree {

/*	Given a singly linked list where elements are sorted in ascending order, 
 *  convert it to a height balanced BST.*/
	
	struct TreeNodeNew {
	    int val;
	    TreeNodeNew *left;
	    TreeNodeNew *right;
		int bf;
		TreeNodeNew(int val = 0, TreeNodeNew * left = NULL, TreeNodeNew * right = NULL, int bf = 0) {
			this->val = val;
			this->left = left;
			this->right = right;
			this->bf = bf;
		}
	};

	class Solution {
	public:
		TreeNode * sortedListToBST(ListNode * head) {
			TreeNodeNew * ansNew = NULL;
			ListNode * temp = head;
			while (temp) {
				avlInsert(ansNew, temp->val);
				temp = temp->next;
			}
			TreeNode * ans = NULL;
			if (ansNew) reBuild(ansNew, ans);
			return ans;
		}

		void reBuild(TreeNodeNew * &nowNew, TreeNode * &now) {
			now = new TreeNode(nowNew->val);
			if (nowNew->left) reBuild(nowNew->left, now->left);
			if (nowNew->right) reBuild(nowNew->right, now->right);
		}

		inline int MAX(int a, int b) {
			if (a > b) return a + 1;
			return b + 1;
		}

		void avlInsert(TreeNodeNew * &root, const int entry) {
			bool unbalanced;
			avlInsertInside(root, entry, unbalanced);
		}

		void lR(TreeNodeNew * &parent) {
			TreeNodeNew * child = parent->left;
			if (child->bf == 1) {
				parent->left = child->right;
				child->right = parent;
				parent->bf = 0;
				parent = child;
			}
			else {
				TreeNodeNew * grandChild = child->right;
				parent->left = grandChild->right;
				child->right = grandChild->left;
				grandChild->right = parent;
				grandChild->left = child;
				switch (grandChild->bf) {
				case 0:
					parent->bf = child->bf = 0;
					break;
				case 1:
					parent->bf = -1;
					child->bf = 0;
					break;
				case -1:
					parent->bf = 0;
					child->bf = 1;
				}
				parent = grandChild;
			}
			parent->bf = 0;
		}

		void rR(TreeNodeNew * &parent) {
			TreeNodeNew * child = parent->right;
			if (child->bf == -1) {
				parent->right = child->left;
				child->left = parent;
				parent->bf = 0;
				parent = child;
			}
			else {
				TreeNodeNew * grandChild = child->left;
				parent->right = grandChild->left;
				child->left = grandChild->right;
				grandChild->right = child;
				grandChild->left = parent;
				switch (grandChild->bf) {
				case 0:
					parent->bf = child->bf = 0;
					break;
				case -1:
					parent->bf = 1;
					child->bf = 0;
					break;
				case 1:
					parent->bf = 0;
					child->bf = -1;
				}
				parent = grandChild;
			}
			parent->bf = 0;
		}

		void avlInsertInside(TreeNodeNew * &parent, const int x, bool & unbalanced) {
			if (parent == NULL) {
				parent = new TreeNodeNew(x, 0, 0, 0);
				unbalanced = true;
			}
			else if (x < parent->val) {
				avlInsertInside(parent->left, x, unbalanced);
				if (unbalanced) {
					switch (parent->bf) {
					case 0:
						parent->bf = 1;
						break;
					case -1:
						parent->bf = 0;
						unbalanced = false;
						break;
					case 1:
						lR(parent);
						unbalanced = false;
					}
				}
			}
			else if (x > parent->val) {
				avlInsertInside(parent->right, x, unbalanced);
				if (unbalanced) {
					switch (parent->bf) {
					case 0:
						parent->bf = -1;
						break;
					case 1:
						parent->bf = 0;
						unbalanced = false;
						break;
					case -1:
						rR(parent);
						unbalanced = false;
					}
				}
			}
			else {
				unbalanced = false;
			}
		}
	};
	
}
