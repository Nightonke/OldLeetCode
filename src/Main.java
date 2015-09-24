public class Main {
	
	public static void main(String[] args){
		Solution solution = new Solution();
		
//		[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
		int[][] input = {{2147483647,-1,0,2147483647}, {2147483647,2147483647,2147483647,-1}, {2147483647,-1,2147483647,-1}, {0,-1,2147483647,2147483647}};
		
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				System.out.print(input[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
		
		solution.wallsAndGates(input);
		
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				System.out.print(input[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
		
	}
	
}
