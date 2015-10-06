
public class _0187_Repeated_DNA_Sequences {

/*	All DNA is composed of a series of nucleotides abbreviated as A, C, G, and 
 *  T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to 
 *  identify repeated sequences within the DNA.

	Write a function to find all the 10-letter-long sequences (substrings) that 
	occur more than once in a DNA molecule.

	For example,

	Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

	Return:
	["AAAAACCCCC", "CCCCCAAAAA"].*/
	
	bool nums[1048576], isIn[1048576];
	class Solution {
	public:
		vector<string> findRepeatedDnaSequences(string s) {
			int size = s.length(), sum = 0;
			char letter[4] = {'A', 'C', 'G', 'T'};
			memset(nums, false, sizeof(nums));
			memset(isIn, false, sizeof(isIn));
			vector<string> ans;
			for (int i = 0; i < 9; i++) {
				if (s[i] == 'A') sum = sum * 4 + 0;
				if (s[i] == 'C') sum = sum * 4 + 1;
				if (s[i] == 'G') sum = sum * 4 + 2;
				if (s[i] == 'T') sum = sum * 4 + 3;
			}
			for (int i = 9; i < size; i++) {
				if (s[i] == 'A') sum = sum * 4 + 0;
				if (s[i] == 'C') sum = sum * 4 + 1;
				if (s[i] == 'G') sum = sum * 4 + 2;
				if (s[i] == 'T') sum = sum * 4 + 3;
				sum %= 1048576;
				if (isIn[sum]) continue;
				else if (nums[sum]) {
					isIn[sum] = true;
					string in;
					int S = sum;
					for (int j = 0; j < 10; j++) {
						in.push_back(letter[S % 4]);
						S /= 4;
					}
					reverse(in.begin(), in.end());
					ans.push_back(in);
				}
				nums[sum] = true;
			}
			return ans;
		}
	};
	
}
