
public class _0200_Number_of_Islands {

/*	Given a 2d grid map of '1's (land) and '0's (water), count the number of 
 *  islands. An island is surrounded by water and is formed by connecting 
 *  adjacent lands horizontally or vertically. You may assume all four edges of 
 *  the grid are all surrounded by water.

	Example 1:

	11110
	11010
	11000
	00000
	Answer: 1

	Example 2:

	11000
	11000
	00100
	00011
	Answer: 3*/
	 
	int R, C;
	int dir[4][2] = { 1, 0, -1, 0, 0, 1, 0, -1 };
	bool ** vis;
	char ** G;

	void dfs(int pi, int pj) {
		vis[pi][pj] = true;
		int npi, npj;
		for (int i = 0; i < 4; i++) {
			npi = pi + dir[i][0];
			npj = pj + dir[i][1];
			if (0 <= npi && npi < R && 0 <= npj && npj < C && !vis[npi][npj] && G[npi][npj] == '1') dfs(npi, npj);
		}
	}

	int numIslands(char **grid, int numRows, int numColumns) {
		G = grid;
		vis = (bool **)malloc(sizeof(bool*) * numRows);
		for (int i = 0; i < numRows; i++) vis[i] = (bool *)malloc(sizeof(bool) * numColumns);
		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numColumns; j++) vis[i][j] = false;
		int ans = 0;
		R = numRows;
		C = numColumns;
		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numColumns; j++)
				if (!vis[i][j] && G[i][j] == '1') {
					ans++;
					dfs(i, j);
				}
		for (int i = 0; i < numRows; i++) free(vis[i]);
		free(vis);
		return ans;
	}
	
}
