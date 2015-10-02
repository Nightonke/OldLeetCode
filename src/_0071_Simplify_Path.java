
public class _0071_Simplify_Path {

/*	Given an absolute path for a file (Unix-style), simplify it.

	For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"*/

	class Solution {
	public:
	    string simplifyPath(string path) {
	        vector<string> fileName;
	        for (int i = 0; i < path.size(); i++) {
	            if (path[i] == '/') {
	                if (i < path.size() - 1 && path[i + 1] == '/') {  // situation for "//"
	                    i += 1 - 1;
	                    continue;
	                }
	                if ((i == path.size() - 2 && path[i + 1] == '.') || (i < path.size() - 2 && path[i + 1] == '.' && path[i + 2] == '/')) {  // situation for "/."
	                    i += 2 - 1;
	                    continue;
	                }
	                if ((i == path.size() - 3 && path[i + 1] == '.' && path[i + 2] == '.') || (i < path.size() - 3 && path[i + 1] == '.' && path[i + 2] == '.' && path[i + 3] == '/')) {  // situation for "/.."
	                    i += 3 - 1;
	                    if (fileName.size() > 0) {
	                        fileName.pop_back();    
	                    }
	                    continue;
	                }
	                string name;  // if the situation is not above, it is a valid file name
	                int j = i + 1;
	                for (; j < path.size() && path[j] != '/'; j++) {
	                    name.push_back(path[j]);
	                }
	                if (name.size() != 0) fileName.push_back(name);
	                i = j - 1;
	                continue;
	            }
	        }
	        string ans;
	        for (int i = 0; i < fileName.size(); i++) {
	            ans += "/" + fileName[i];
	        }
	        if (ans.size() == 0) ans = "/";
	        return ans;
	    }
	};
	
}
