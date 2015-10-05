
public class _0126_Word_Ladder_II {

/*	Given two words (beginWord and endWord), and a dictionary's word list, find 
 *  all shortest transformation sequence(s) from beginWord to endWord, such 
 *  that:

	Only one letter can be changed at a time
	Each intermediate word must exist in the word list
	For example,

	Given:
	beginWord = "hit"
	endWord = "cog"
	wordList = ["hot","dot","dog","lot","log"]
	Return
	  [
	    ["hit","hot","dot","dog","cog"],
	    ["hit","hot","lot","log","cog"]
	  ]
	Note:
	All words have the same length.
	All words contain only lowercase alphabetic characters.*/
	
	class Solution {
	public:
		vector<vector<string> > ans;  // answer
		vector<string> backtraceList;  //  list for backtracing, maybe an answer
		map<string, vector<string> > edges;  // treat every string as a point
		string st;  // start string
		string ed;  // end string
		unordered_set<string> visit;  // BFS visit
		unordered_set<string> unvisit;  // BFS unvisit
		vector<vector<string>> findLadders(string start, string end, unordered_set<string> & dict) {
			ans.clear();
			backtraceList.clear();
			edges.clear();
			if (dict.size() == 0) return ans;
			st = start;
			ed = end;
			visit.clear();
			unvisit = dict;
			BFS();  // bfs makes graph
			DFS(ed);  // dfs find roads(from end to start)
			return ans;
		}
		void BFS() {
			int cur = 1;  // current points to check
			int next = 0;  // next points to check
			int l;  // the length of each word
			bool found = false;
			queue<string> q;
			q.push(st);
			unvisit.insert(ed);
			unvisit.erase(st);  // maybe there is another start string in the dict

			while (!q.empty()) {
				string w = q.front();
				q.pop();
				cur--;
				l = w.size();
				for (int i = 0; i < l; i++) {
					char originalChar = w[i];
					string nw = w;
					for (char c = 'a'; c <= 'z'; c++) {
						nw[i] = c;
						if (unvisit.find(nw) != unvisit.end()) {  // an unvisited word
							if (visit.find(nw) == visit.end()) {  // there is no this word in visit
								visit.insert(nw);
								next++;  // more word to visit next time
								q.push(nw);
							}
							map<string, vector<string> >::iterator iter = edges.find(nw);
							if (iter != edges.end()) {  // a new point of an existed edge
								(*iter).second.push_back(w);
							}
							else {  // a new edge
								vector<string> temp;
								temp.push_back(w);
								edges[nw] = temp;
							}
							if (nw == ed) found = true;
						}
					}
					w[i] = originalChar;
				}
				if (cur == 0) {
					if (found) break;
					cur = next;
					next = 0;
					unordered_set<string>::iterator iter = visit.begin();
					for (; iter != visit.end(); iter++) unvisit.erase(*iter);
					visit.clear();
				}
			}
		}
		void DFS(string w) {
			if (w == st) {  // find start string
				vector<string> temp;
				temp.push_back(st);
				for (int i = 0, s = backtraceList.size(); i < s; i++)
					temp.push_back(backtraceList[s - i - 1]);
				ans.push_back(temp);
				return;
			}
			backtraceList.push_back(w);
			map<string, vector<string> >::iterator iter = edges.find(w);
			if (iter != edges.end()) {
				int s = iter->second.size();
				for (int i = 0; i < s; i++) DFS(iter->second[i]);
			}
			backtraceList.pop_back();
		}
	};
	
}
