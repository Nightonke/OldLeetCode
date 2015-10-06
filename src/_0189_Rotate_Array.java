
public class _0189_Rotate_Array {

/*	Rotate an array of n elements to the right by k steps.

	For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to 
	[5,6,7,1,2,3,4].

	Note:
	Try to come up as many solutions as you can, there are at least 3 different 
	ways to solve this problem.

	[show hint]

	Related problem: Reverse Words in a String II*/

	class Solution {
	public:
		void rotate(int nums[], int n, int k) {
			if (n == 0 || k % n == 0) return;
			int p = 0, last = nums[0], startp = 0, q, temp;
			for (int i = 0; i < n; i++) {
				q = (p + k) % n;
				if (q == startp) {
					nums[startp] = last;
					last = nums[++startp];
					p = startp;
					continue;
				}
				temp = nums[q];
				nums[q] = last;
				last = temp;
				p = q;
			}
		}
	};
	
}
