
public class _0087_Scramble_String {

/*	Given a string s1, we may represent it as a binary tree by partitioning it 
 *  to two non-empty substrings recursively.

	Below is one possible representation of s1 = "great":

	    great
	   /    \
	  gr    eat
	 / \    /  \
	g   r  e   at
	           / \
	          a   t
	To scramble the string, we may choose any non-leaf node and swap its two 
	children.

	For example, if we choose the node "gr" and swap its two children, it 
	produces a scrambled string "rgeat".

	    rgeat
	   /    \
	  rg    eat
	 / \    /  \
	r   g  e   at
	           / \
	          a   t
	We say that "rgeat" is a scrambled string of "great".

	Similarly, if we continue to swap the children of nodes "eat" and "at", it 
	produces a scrambled string "rgtae".

	    rgtae
	   /    \
	  rg    tae
	 / \    /  \
	r   g  ta  e
	       / \
	      t   a
	We say that "rgtae" is a scrambled string of "great".

	Given two strings s1 and s2 of the same length, determine if s2 is a 
	scrambled string of s1.*/
	
	class Solution {
	public:
	    int * letters;
	    string S1, S2;
	    bool isScramble(string s1, string s2) {
	        if (s1.size() != s2.size()) return false;
	        letters = new int[60];
	        S1 = s1, S2 = s2;
	        return dfs(0, S1.size(), 0, S2.size());
	    }
	    bool dfs(int l1, int r1, int l2, int r2) {  // 这里用四个下标来指代当前两个字符串

	        if (S1.substr(l1, r1 - l1) == S2.substr(l2, r2 - l2)) return true;  // 如果当前两个字符串相等了

	        for (int i = 0; i < 52; i++) letters[i] = 0;  // 检查两个当前字符串的字母类型和个数是否一样
	        for (int i = l1; i < r1; i++) 
	            if ('A' <= S1[i] && S1[i] <= 'Z') letters[S1[i] - 'A']++;
	            else letters[S1[i] - 71]++;
	        for (int i = l2; i < r2; i++)
	            if ('A' <= S2[i] && S2[i] <= 'Z') letters[S2[i] - 'A']--;
	            else letters[S2[i] - 71]--;
	        for (int i = 0; i < 52; i++) if (letters[i]) return false;

	        for (int i = 1; i < r1 - l1; i++) {
	            if ((dfs(l1, l1 + i, l2, l2 + i) && dfs(l1 + i, r1, l2 + i, r2))) return true;  // 如果gr和X1X2匹配且eat和X3X4X5匹配
	            if ((dfs(l1, l1 + i, r2 - i, r2) && dfs(l1 + i, r1, l2, r2 - i))) return true;  // 如果gr和X4X5匹配且eat和X1X2X3匹配
	        }

	        return false;

	    }
	};
	
}
