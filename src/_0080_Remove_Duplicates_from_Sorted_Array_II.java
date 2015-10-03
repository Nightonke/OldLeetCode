
public class _0080_Remove_Duplicates_from_Sorted_Array_II {

/*	Follow up for "Remove Duplicates":
		What if duplicates are allowed at most twice?

		For example,
		Given sorted array nums = [1,1,1,2,2,3],

		Your function should return length = 5, with the first five elements of 
		nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the 
		new length.
*/	
	
	class Solution {
	public:
	    int removeDuplicates(int A[], int n) {
	        if (n <= 2) return n;
	        vector<int> del;
	        for (int i = 0; i < n - 2; i++) {
	            if (A[i] == A[i + 1] && A[i + 1] == A[i + 2]) del.push_back(i + 2);
	        }
	        int * temp = new int[n];
	        int j = 0;
	        int k = 0;
	        for (int i = 0; i < n; i++) {
	            if (del.size() > 0 && i == del[j]) {
	                if (j < del.size() - 1) j++;
	                continue;
	            } else {
	                temp[k++] = A[i];
	            }
	        }
	        for (int i = 0; i < k; i++) A[i] = temp[i];
	        delete []temp;
	        return k;
	    }
	};
	
}
