
public class _0207_Course_Schedule {

/*	There are a total of n courses you have to take, labeled from 0 to n - 1.

	Some courses may have prerequisites, for example to take course 0 you have 
	to first take course 1, which is expressed as a pair: [0,1]

	Given the total number of courses and a list of prerequisite pairs, is it 
	possible for you to finish all courses?

	For example:

	2, [[1,0]]
	There are a total of 2 courses to take. To take course 1 you should have 
	finished course 0. So it is possible.

	2, [[1,0],[0,1]]
	There are a total of 2 courses to take. To take course 1 you should have 
	finished course 0, and to take course 0 you should also have finished course 
	1. So it is impossible.

	Note:
	The input prerequisites is a graph represented by a list of edges, not 
	adjacency matrices. Read more about how a graph is represented.*/
	
	bool canFinish(int numCourses, int** prerequisites, int prerequisitesRowSize, int prerequisitesColSize) {
		int * Indegrees;
		bool ** IsConnect;
		Indegrees = (int*)malloc(sizeof(int) * numCourses);
		IsConnect = (bool**)malloc(sizeof(bool*) * numCourses);
		for (int i = 0; i < numCourses; i++) {
			IsConnect[i] = (bool*)malloc(sizeof(bool) * numCourses);
		}
		//memset(Indegrees, 0, sizeof(Indegrees));
		//memset(IsConnect, false, sizeof(IsConnect));  something wrong here
		for (int i = 0; i < numCourses; i++) Indegrees[i] = 0;
		for (int i = 0; i < numCourses; i++) for (int j = 0; j < numCourses; j++) IsConnect[i][j] = false;
		for (int i = 0; i < prerequisitesRowSize; i++) {
			int To = prerequisites[i][0];
			for (int j = 1; j < prerequisitesColSize; j++) {
				if (0 <= prerequisites[i][j] && prerequisites[i][j] < numCourses && !IsConnect[prerequisites[i][j]][To]) {
					IsConnect[prerequisites[i][j]][To] = true;
					Indegrees[To]++;
				}
			}
		}
		int * Q = (int*)malloc(sizeof(int) * numCourses);
		int head = 0, tail = 0, Ans = 0;
		for (int i = 0; i < numCourses; i++) {
			if (Indegrees[i] == 0) {
				Q[tail++] = i;
				Ans++;
			}
		}
		while (head < tail) {
			for (int i = 0; i < numCourses; i++) {
				if (IsConnect[Q[head]][i]) {
					IsConnect[Q[head]][i] = false;
					Indegrees[i]--;
					if (Indegrees[i] == 0) {
						Q[tail++] = i;
						Ans++;
					}
				}
			}
			head++;
		}
		free(Indegrees);
		for (int i = 0; i < numCourses; i++) {
			free(IsConnect[i]);
		}
		free(Q);
		return Ans == numCourses;
	}
	
}
