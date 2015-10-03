
public class _0079_Word_Search {

/*	Given a 2D board and a word, find if the word exists in the grid.

	The word can be constructed from letters of sequentially adjacent cell, 
	where "adjacent" cells are those horizontally or vertically neighboring. 
	The same letter cell may not be used more than once.

	For example,
	Given board =

	[
	  ["ABCE"],
	  ["SFCS"],
	  ["ADEE"]
	]
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.*/
	
	class Solution {
	public:
	    bool exist(vector<vector<char> > &board, string word) {
	        if (board.size() == 0 || (board.size() * board[0].size() < word.size())) {
	            return false;
	        }
	        dir[0][0] = -1;
	        dir[0][1] = 0;
	        dir[1][0] = 1;
	        dir[1][1] = 0;
	        dir[2][0] = 0;
	        dir[2][1] = 1;
	        dir[3][0] = 0;
	        dir[3][1] = -1;
	        ans = false;
	        
	        t_length = word.size();
	        target = new char[word.size()];
	        for (int i = 0; i < word.size(); i++) target[i] = word[i];
	        
	        h = board.size();
	        w = board[0].size();
	        
	        mapp = new char*[h];
	        for (int i = 0; i < h; i++) mapp[i] = new char[w];
	        
	        vis = new short*[h];
	        for (int i = 0; i < h; i++) vis[i] = new short[w];
	        
	        
	        for (int ii = 0; ii < h; ii++) {
	            for (int jj = 0; jj < w; jj++) {
	                mapp[ii][jj] = board[ii][jj];
	                vis[ii][jj] = 0;
	            }
	        }
	        
	        for (int i = 0; i < h; i++) {
	            for (int j = 0; j < w; j++) {
	                if (board[i][j] == word[0]) {
	                    
	                    vis[i][j] = 1;
	                    search(1, i, j);
	                    if (ans) {
	                        return ans;
	                    }
	                    vis[i][j] = 0;
	                }
	            }
	        }
	        
	        for (int i = 0; i < h; i++) delete []mapp[i];
	        delete []mapp;
	        
	        for (int i = 0; i < h; i++) delete []vis[i];
	        delete []vis;
	        
	        return ans;
	    }
	    void search(int pos, int i, int j) {
	        if (pos == t_length) {
	            ans = true;
	            return;
	        }
	        for (int k = 0; k < 4 && ans == false; k++) {
	            if (0 <= i + dir[k][0] && i + dir[k][0] < h && 0 <= j + dir[k][1] && j + dir[k][1] < w && (!vis[i + dir[k][0]][j + dir[k][1]]) && (target[pos] == mapp[i + dir[k][0]][j + dir[k][1]])) {
	                vis[i + dir[k][0]][j + dir[k][1]] ^= 1;
	                search(pos + 1, i + dir[k][0], j + dir[k][1]);
	                vis[i + dir[k][0]][j + dir[k][1]] ^= 1;
	            }
	        }
	    }
	private:
	    int dir[4][2];
	    int w, h;
	    short **vis;
	    char *target;
	    int t_length;
	    char **mapp;
	    bool ans;
	};
	
}
