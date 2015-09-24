public class Main {
	
	public static void main(String[] args){
		Solution solution = new Solution();
		
		TreeNode root = new TreeNode(2);
		TreeNode rootLeft = new TreeNode(1);
		TreeNode rootRight = new TreeNode(3);
		root.left = rootLeft;
		root.right = rootRight;
		TreeNode p = new TreeNode(3);
		
		TreeNode ans = solution.inorderSuccessor(root, p);
		
		if (ans == null) {
			System.out.println("isNULL");
		} else {
			System.out.println(ans.val);
		}
		
	}
	
}
