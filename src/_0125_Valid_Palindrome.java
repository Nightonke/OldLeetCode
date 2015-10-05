
public class _0125_Valid_Palindrome {

/*	Given a string, determine if it is a palindrome, considering only 
 *  alphanumeric characters and ignoring cases.

	For example,
	"A man, a plan, a canal: Panama" is a palindrome.
	"race a car" is not a palindrome.

	Note:
	Have you consider that the string might be empty? This is a good question 
	to ask during an interview.

	For the purpose of this problem, we define empty string as valid palindrome.
	*/
	
	class Solution {
	public:
	    bool isPalindrome(string s) {
	        for (int i = 0, j = s.size() - 1; i < j; i++, j--) {
	            while (i < s.size() && !isAlphanumeric(s[i])) i++;
	            while (j >= 0 && !isAlphanumeric(s[j])) j--;
	            if (i >= j) break;
	            if (!(s[i] == s[j] || s[i] - s[j] == 32 || s[j] - s[i] == 32)) return false;
	        }
	        return true;
	    }
	    bool isAlphanumeric(char a);
	};

	bool Solution::isAlphanumeric(char a) {return (('a' <= a && a <= 'z') || ('A' <= a && a <= 'Z') || '0' <= a && a <= '9');}
	
}
