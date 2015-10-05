
public class _0130_Surrounded_Regions {

/*	Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

	A region is captured by flipping all 'O's into 'X's in that surrounded region.

	For example,
	X X X X
	X O O X
	X X O X
	X O X X
	After running your function, the board should be:

	X X X X
	X X X X
	X X X X
	X O X X*/
	
	int Edir[8][2] = {-1, 0, -1, 1, 0, 1, 1, 1, 1, 0, 1, -1, 0, -1, -1, -1};
	int Fdir[4][2] = {0, 1, 0, -1, 1, 0, -1, 0};

	class Solution {
	public:
	    void solve(vector<vector<char> > &board) {

	        Board = board;

	        vis.resize(board.size());
	        for (int i = 0; i < vis.size(); i++) {
	            vis[i].resize(board[i].size());
	            for (int j = 0; j < board[i].size(); j++) {
	                vis[i][j] = false;
	            }
	        }

	        for (int i = 0; i < board.size(); i++) {
	            for (int j = 0; j < board[i].size(); j++) {
	                if (vis[i][j] == false && board[i][j] == 'O') {
	                    OBlock.clear();
	                    OBlock.push_back(make_pair(i, j));
	                    DFS(i, j);
	                    bool isCaptured = true;
	                    for (int k = 0; k < OBlock.size(); k++) {
	                        if (OBlock[k].first == 0 || OBlock[k].first == Board.size() - 1 || OBlock[k].second == 0 || OBlock[k].second == Board[OBlock[k].first].size() - 1) {
	                            isCaptured = false;
	                            break;
	                        }
	                    }
	                    if (isCaptured) {
	                        for (int k = 0; k < OBlock.size(); k++) {
	                            board[OBlock[k].first][OBlock[k].second] = 'X';
	                        }
	                    }
	                    
	                }
	            }
	        }

	    }
	    void DFS(int i, int j) {
	        for (int k = 0; k < 4; k++) {
	            if (isValid(i + Fdir[k][0], j + Fdir[k][1])) {
	                vis[i + Fdir[k][0]][j + Fdir[k][1]] = true;
	                OBlock.push_back(make_pair(i + Fdir[k][0], j + Fdir[k][1]));
	                DFS(i + Fdir[k][0], j + Fdir[k][1]);
	            }
	        }
	    }
	    bool isValid(int i, int j) {
	        return i >= 0 && j >= 0 && i < Board.size() && j < Board[i].size() && Board[i][j] == 'O' && vis[i][j] == false;
	    }
	private:
	    vector<vector<char> > Board;
	    vector<pair<int, int> > OBlock;
	    vector<vector<bool> > vis;
	};
	
}
