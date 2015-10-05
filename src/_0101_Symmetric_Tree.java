
public class _0101_Symmetric_Tree {

/*	Given a binary tree, check whether it is a mirror of itself (ie, symmetric 
 *  around its center).

	For example, this binary tree is symmetric:

	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	But the following is not:
	    1
	   / \
	  2   2
	   \   \
	   3    3
	Note:
	Bonus points if you could solve it both recursively and iteratively.*/
	
	class Solution {
	public:
	    bool isSymmetric(TreeNode *root) {
	        t.clear();
	        if (root != NULL) gogogo(root, 0);
	        for (int i = 1; i < t.size(); i++) {
	            for (int s = 0, e = t[i].size() - 1; s < e; s++, e--) {
	                if (t[i][s] != t[i][e]) return false;
	            }
	        }
	        return true;
	    }
	    void gogogo(TreeNode * nowRoot, int nowLevel) {
	        if (nowLevel >= t.size()) {
	            vector<string> tempV;
	            if (nowRoot == NULL) tempV.push_back("NULL");
	            else tempV.push_back(numToStr(nowRoot->val));
	            t.push_back(tempV);
	        } else {
	            if (nowRoot == NULL) t[nowLevel].push_back("NULL");
	            else t[nowLevel].push_back(numToStr(nowRoot->val));
	        }
	        if (nowRoot == NULL) return;
	        gogogo(nowRoot->left, nowLevel + 1);
	        gogogo(nowRoot->right, nowLevel + 1);
	    }
	    string numToStr(int num) {
	        stringstream ss;
	        ss << num;
	        return ss.str();
	    }
	private:
	    vector<vector<string> > t;
	};

	
}
