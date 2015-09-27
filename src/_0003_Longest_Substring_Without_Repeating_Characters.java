
public class _0003_Longest_Substring_Without_Repeating_Characters {

/*	Given a string, find the length of the longest substring without repeating 
 * characters. For example, the longest substring without repeating letters for 
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring 
 * is "b", with the length of 1.*/
	
	class Solution {
	public:
	    int lengthOfLongestSubstring(string s) {
	        int maxDis = 0, newDis = 0;
	        int latestPos[256];
	        for (int i = 0; i < 256; latestPos[i++] = -1);
	        for (int i = 0; i < s.size(); i++) {
	            if (latestPos[s[i]] == -1 ||latestPos[s[i]] < i - newDis)
	                newDis++;
	            else
	                newDis = i - latestPos[s[i]];
	            latestPos[s[i]] = i;
	            if (newDis > maxDis) maxDis = newDis;
	        }
	        return maxDis;
	    }
	};
	
}
