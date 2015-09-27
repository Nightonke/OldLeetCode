public class Solution {
    private static final int INF = 2147483647;
	
	private int[][] m;
	private int gateNumber;
	private int[][] gates;
	private boolean[][] visit;
	private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private int W, H;
	
	public void wallsAndGates(int[][] rooms) {
		
		if (rooms.length == 0) {
		    return;
		}
		
		gates = new int[rooms.length * rooms[0].length][];
		
		gateNumber = 0;
		m = new int[rooms.length][];
		visit = new boolean[rooms.length][];
		H = rooms.length;
		W = rooms[0].length;
		
		for (int i = 0; i < rooms.length; i++) {
			m[i] = new int[rooms[i].length];
			visit[i] = new boolean[rooms[i].length];
			for (int j = 0; j < rooms[i].length; j++) {
				m[i][j] = rooms[i][j];
				if (rooms[i][j] == 0) {
					gates[gateNumber] = new int[2];
					gates[gateNumber][0] = i;
					gates[gateNumber][1] = j;
					gateNumber++;
				}
			}
		}

		// use BFS to travel all the map from every gate
		for (int i = 0; i < gateNumber; i++) {
			memset();
			Queue<Pair> queue = new LinkedList<Pair>();
			queue.add(new Pair(gates[i][0], gates[i][1], 0));
			visit[gates[i][0]][gates[i][1]] = true;
			while (!queue.isEmpty()) {
				Pair pair = queue.poll();
				for (int j = 0; j < 4; j++) {
					int nextI = pair.i + dir[j][0];
					int nextJ = pair.j + dir[j][1];
					int nextS = pair.step + 1;
					if (isValid(nextI, nextJ) && m[nextI][nextJ] == INF) {
						// is a room
						if (nextS < rooms[nextI][nextJ]) {
							// is better
							rooms[nextI][nextJ] = nextS;
						}
						queue.add(new Pair(nextI, nextJ, nextS));
						visit[nextI][nextJ] = true;
					}
				}
			}
		}
	}
	
	private void memset() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				visit[i][j] = false;
			}
		}
	}
	
	private boolean isValid(int i, int j) {
		return 0 <= i && i < H && 0 <= j && j < W && !visit[i][j];
	}
	
	class Pair {
		public int i, j, step;
		Pair(int i, int j, int step) {
			this.i = i;
			this.j = j;
			this.step = step;
		}
	}
}