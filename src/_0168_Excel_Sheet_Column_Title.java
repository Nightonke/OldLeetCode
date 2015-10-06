
public class _0168_Excel_Sheet_Column_Title {

/*	Given a positive integer, return its corresponding column title as appear in 
 *  an Excel sheet.

	For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB */
	
	class Solution {
	public:
	    string convertToTitle(int n) {
	        string s;
	        while (n) {
	            n--;
	            s.push_back(n % 26 + 'A');
	            n /= 26;
	        }
	        reverse(s.begin(), s.end());
	        return s;
	    }
	};
	
}
