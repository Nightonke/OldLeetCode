
public class _0214_Shortest_Palindrome {

/*	Given a string S, you are allowed to convert it to a palindrome by adding 
 *  characters in front of it. Find and return the shortest palindrome you can 
 *  find by performing this transformation.

	For example:

	Given "aacecaaa", return "aaacecaaa".

	Given "abcd", return "dcbabcd".*/
	
	//通过构造一个字符串S，再利用KMP算法可以解决这个问题
	//其中S=(输入的s)+(一个绝不会在s中出现的符号，比如#)+(s的翻转rev_s)
	//在用完KMP算法之后，我们可以得到一个数组p
	//数组p上的值为每个字符的前缀函数的值(详情看KMP算法)
	//我们只需要看p中的最后一个值即可
	//因为它显示了rev_s中最大的、与原有字符串s的前缀匹配上的子串
	//最后我们只需要将前k个rev_s中的字符和原有字符串相连即可
	//其中k为p的最后一个值和原有字符串s的长度的差值

	char * shortestPalindrome(char * s) {

		int length = strlen(s);
		int Length = 2 * length + 1;
		char * rev_s = (char*)malloc(sizeof(char) * (length + 2));
		char * l = (char*)malloc(sizeof(char) * (2 * length + 2));

		for (int i = length - 1; i >= 0; i--) {
			rev_s[i] = s[length - i - 1];
		}
		rev_s[length] = '\0';
		
		for (int i = 0; i < length; i++) l[i] = s[i];
		l[length] = '#';
		for (int i = 0; i < length; i++) l[i + length + 1] = rev_s[i];
		l[2 * length + 1] = '\0';

		int * p = (int*)malloc(sizeof(int) * Length);
		for (int i = 0; i < Length; i++) p[i] = 0;

		for (int i = 1; i < Length; i++) {
			int j = p[i - 1];
			while (j > 0 && l[i] != l[j]) j = p[j - 1];
			p[i] = (j += l[i] == l[j]);
		}

		char * sub_s = (char*)malloc(sizeof(char) * (2 * length - p[Length - 1] + 1));
		for (int i = length - p[Length - 1] - 1; i >= 0; i--) sub_s[i] = rev_s[i];
		for (int i = 0; i < length; i++) sub_s[i + length - p[Length - 1]] = s[i];
		sub_s[2 * length - p[Length - 1]] = '\0';

		free(rev_s);
		free(l);

		return sub_s;
	}
	
}
