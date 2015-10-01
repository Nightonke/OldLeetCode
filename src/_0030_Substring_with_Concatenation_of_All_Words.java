
public class _0030_Substring_with_Concatenation_of_All_Words {

/*	You are given a string, s, and a list of words, words, that are all of the 
 *  same length. Find all starting indices of substring(s) in s that is a 
 *  concatenation of each word in words exactly once and without any intervening 
 *  characters.

	For example, given:
	s: "barfoothefoobarman"
	words: ["foo", "bar"]

	You should return the indices: [0,9].
	(order does not matter).*/
	
	class Solution {
	public:
	    map<string, int> shouldBe;  // L中string应有的数量
	    map<string, int> now;  // 当前构建的string的数量
	    vector<int> findSubstring(string S, vector<string> &L) {
	        vector<int> ans;
	        for (int i = 0; i < L.size(); i++) {
	            if (shouldBe.find(L[i]) != shouldBe.end()) {
	                shouldBe[L[i]]++;
	            } else {
	                shouldBe[L[i]] = 1;
	            }
	        }
	        int alength = L[0].size();  // L中每个string的长度
	        int sNum, nNum;  // S中某个string的个数和now中对应string的个数
	        int startPos;  // 符合条件的某个substr的起点

	        for (int q = 0; q < alength; q++) {
	            now.clear();
	            for (int i = q; i + alength <= S.size(); i += alength) {

	                if (now.empty()) startPos = i;  // 如果now是空的说明是新的开始

	                string temp = S.substr(i, alength);

	                if (shouldBe.find(temp) != shouldBe.end()) sNum = shouldBe[temp];  // 判断现在的temp是否在S中
	                else sNum = 0;

	                if (sNum == 0) {  // 如果不在清空now，准备下一次新的开始
	                    now.clear();
	                } else {  // 如果在S中
	                    if (now.find(temp) == now.end()) {  // 如果不在now中
	                        now[temp] = 1;
	                        nNum = 1;
	                    } else {  // 如果在now中
	                        nNum = ++now[temp];
	                    }
	                    if (nNum > sNum) {  // 如果now中的temp数量已经多过了S中，那么就重新开始，注意i的坐标应是当前startPos的下一位
	                        now.clear();
	                        i = startPos;
	                    }
	                    if (now == shouldBe) {  // 如果匹配成功
	                        ans.push_back(startPos);
	                        i = startPos;
	                        now.clear();
	                    }
	                }
	            }
	        }
	        return ans;
	    }
	};
	
}
