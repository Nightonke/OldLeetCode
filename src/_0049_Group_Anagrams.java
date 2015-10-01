
public class _0049_Group_Anagrams {

/*	Given an array of strings, group anagrams together.

	For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
	Return:

	[
	  ["ate", "eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	Note:
	For the return value, each inner list's elements must follow the 
	lexicographic order.
	All inputs will be in lower-case.
	Update (2015-08-09):
	The signature of the function had been updated to return list<list<string>> 
	instead of list<string>, as suggested here. If you still see your function 
	signature return a list<string>, please click the reload button  to reset 
	your code definition.*/
	
	class Solution {
	public:
	    vector<string> anagrams(vector<string> &strs) {
	        map<string, multiset<string> > strM;
	        for (vector<string>::iterator iter = strs.begin(); iter != strs.end(); iter++) {
	            strM[getKey(*iter)].insert(*iter);
	        }
	        vector<string> ans;
	        for (map<string, multiset<string> >::iterator iter = strM.begin(); iter != strM.end(); iter++) {
	            if (iter->second.size() == 1) continue;
	            for (set<string>::iterator iter2 = iter->second.begin(); iter2 != iter->second.end(); iter2++) {
	                ans.push_back(*iter2);
	            }
	        }
	        return ans;
	    }
	    string getKey(string s) {
	        string sortS = s;
	        sort(sortS.begin(), sortS.end());
	        return sortS;
	    }
	};
	
}
