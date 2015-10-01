
public class _0058_Length_of_Last_Word {

/*	Given a string s consists of upper/lower-case alphabets and empty space 
 *  characters ' ', return the length of last word in the string.

			If the last word does not exist, return 0.

			Note: A word is defined as a character sequence consists of 
			non-space characters only.

			For example, 
			Given s = "Hello World",
			return 5.*/
	
	class Solution {
	public:
	    int lengthOfLastWord(const char *s) {
	        int length, i;
	        for (length = 0; s[length] != '\0'; length++);
	        for (; s[length - 1] == ' '; length--);
	        for (i = length - 1; i >= 0 && s[i] != ' '; i--);
	        return length - i - 1;
	    }
	};
	
}
