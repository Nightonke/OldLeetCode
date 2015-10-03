
public class _0076_Minimum_Window_Substring {

/*	Given a string S and a string T, find the minimum window in S which will 
 *  contain all the characters in T in complexity O(n).

	For example,
	S = "ADOBECODEBANC"
	T = "ABC"
	Minimum window is "BANC".

	Note:
	If there is no such window in S that covers all characters in T, return the 
	empty string "".

	If there are multiple such windows, you are guaranteed that there will 
	always be only one unique minimum window in S.*/
	
	char *minWindow(char *S, char *T) {
		int SL = strlen(S), TL = strlen(T);
		bool inT['z' + 1] = { false };
		int num['z' + 1] = { 0 };
		for (int i = 0; i < TL; i++) num[T[i]] += inT[T[i]] = true;
		int ps1 = 0, ps2 = -1, ansP = 0, ansL = SL + 1;
		while (ps2 < SL)
			if (!TL) {
				if (ansL > ps2 - ps1 + 1) ansL = ps2 + 1 - (ansP = ps1);
				if (inT[S[ps1]] && ++num[S[ps1]] > 0) TL++;
				ps1++;
			}
			else if (--num[S[++ps2]] >= 0 && inT[S[ps2]]) TL--;
		if ((S + ansP)[ansL]) (S + ansP)[ansL] = '\0';
		return ansL == SL + 1 ? "" : S + ansP;
	}
	
}
