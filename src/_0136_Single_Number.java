
public class _0136_Single_Number {

/*	Given an array of integers, every element appears twice except for one. Find 
 *  that single one.

	Note:
	Your algorithm should have a linear runtime complexity. Could you implement 
	it without using extra memory?*/
	
	class Solution {
	public:
	    int singleNumber(int A[], int n) {
	        int num, i;
	        for(i = num = 0; i < n; num^=A[i++]) ;
	        return num;
	    }
	};
	
}