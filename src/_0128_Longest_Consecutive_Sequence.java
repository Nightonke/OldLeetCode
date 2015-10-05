
public class _0128_Longest_Consecutive_Sequence {

/*	Given an unsorted array of integers, find the length of the longest 
 *  consecutive elements sequence.

	For example,
	Given [100, 4, 200, 1, 3, 2],
	The longest consecutive elements sequence is [1, 2, 3, 4]. Return its 
	length: 4.

	Your algorithm should run in O(n) complexity.*/
	
	class Solution {
	public:
	    int longestConsecutive(vector<int> &num) {
	        map<int, int> m;
	        for (int i = 0; i < num.size(); i++) {
	            
	            if (m.count(num[i])) continue;

	            m[num[i]] = num[i];

	            if (m.count(num[i] - 1)) {

	                m[num[i]] = m[num[i] - 1];
	                m[m[num[i]]] = num[i];

	            }

	            if (m.count(num[i] + 1)) {
	                
	                int tail = m[num[i] + 1];
	                m[tail] = m[num[i]];
	                m[m[num[i]]] = tail;

	            }
	        }

	        map<int, int>::iterator iter;
	        int Max = 0;
	        for (iter = m.begin(); iter != m.end(); iter++) {
	            if (ABS(iter->first, iter->second) > Max) Max = ABS(iter->first, iter->second);
	        }
	        return Max + 1;
	    }
	    int ABS(int a, int b) {
	        return a - b < 0 ? b - a : a - b;
	    }
	};
	
}
