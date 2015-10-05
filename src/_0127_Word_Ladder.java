
public class _0127_Word_Ladder {

/*	Given two words (beginWord and endWord), and a dictionary's word list, find 
 *  the length of shortest transformation sequence from beginWord to endWord, 
 *  such that:

	Only one letter can be changed at a time
	Each intermediate word must exist in the word list
	For example,

	Given:
	beginWord = "hit"
	endWord = "cog"
	wordList = ["hot","dot","dog","lot","log"]
	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	return its length 5.

	Note:
	Return 0 if there is no such transformation sequence.
	All words have the same length.
	All words contain only lowercase alphabetic characters.*/
	
	class Solution {
	public:
	    struct step {
	        string data;
	        int s;
	        step(string dd, int ss) {
	            data = dd;
	            s = ss;
	        }
	    };
	    int ladderLength(string start, string end, unordered_set<string> &dict) {
	        unordered_set<string> vis;
	        queue<step> q;
	        q.push(step(start, 0));
	        vis.insert(start);
	        while (!q.empty()) {
	            step temp = q.front();
	            q.pop();
	            string made;
	            for (int i = 0; i < temp.data.length(); i++) {
	                made = temp.data;
	                char posLetter = made[i];
	                for (char j = 'a'; j <= 'z'; j++) {
	                    if (posLetter != j) {
	                        made[i] = j;
	                        unordered_set<string>::iterator iter = dict.find(made);
	                        if (vis.find(made) == vis.end() && iter != dict.end()) {
	                            if (made == end) {
	                                return temp.s + 2;
	                            }
	                            q.push(step(*iter, temp.s + 1));
	                            vis.insert(made);
	                        }
	                    }
	                }
	            }
	        }
	        return 0;
	    }
	};


	
}
