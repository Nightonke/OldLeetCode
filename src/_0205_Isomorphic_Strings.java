
public class _0205_Isomorphic_Strings {

/*	Given two strings s and t, determine if they are isomorphic.

	Two strings are isomorphic if the characters in s can be replaced to get t.

	All occurrences of a character must be replaced with another character while 
	preserving the order of characters. No two characters may map to the same 
	character but a character may map to itself.

	For example,
	Given "egg", "add", return true.

	Given "foo", "bar", return false.

	Given "paper", "title", return true.

	Note:
	You may assume both s and t have the same length.*/
	
	bool isIsomorphic(char* s, char* t) {
		int letter1[256] = { 0 };
		for (int i = 0; s[i] != '\0'; i++) {
			if (!letter1[s[i]]) letter1[s[i]] = t[i];
			else if (letter1[s[i]] != t[i]) return false;
		}
		int letter2[256] = { 0 };
		for (int i = 0; t[i] != '\0'; i++) {
			if (!letter2[t[i]]) letter2[t[i]] = s[i];
			else if (letter2[t[i]] != s[i]) return false;
		}
		return true;
	}
	
}
