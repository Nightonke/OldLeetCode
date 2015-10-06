
public class _0159_Longest_Substring_with_At_Most_Two_Distinct_Characters {

/*	Given a string, find the length of the longest substring T that contains at 
 *  most 2 distinct characters.

	For example, Given s = ¡°eceba¡±,

	T is "ece" which its length is 3.*/
	
	class Solution {
	public:
	    int lengthOfLongestSubstringTwoDistinct(string s) {
	        unordered_map<char, int> m;
	        int startIndex = 0, ans = 0;
	        for (int i = 0; i < s.size(); i++) {
	            m[s[i]]++;
	            while (m.size() > 2) {
	                m[s[startIndex]]--;
	                if (m[s[startIndex]] == 0) {
	                    m.erase(s[startIndex]);
	                }
	                startIndex++;
	            }
	            ans = max(ans, i - startIndex + 1);
	        }
	        return ans;
	    }
	};
	
}
