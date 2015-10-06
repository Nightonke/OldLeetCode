
public class _0210_Course_Schedule_II {

/*	There are a total of n courses you have to take, labeled from 0 to n - 1.

	Some courses may have prerequisites, for example to take course 0 you have 
	to first take course 1, which is expressed as a pair: [0,1]

	Given the total number of courses and a list of prerequisite pairs, return 
	the ordering of courses you should take to finish all courses.

	There may be multiple correct orders, you just need to return one of them. 
	If it is impossible to finish all courses, return an empty array.

	For example:

	2, [[1,0]]
	There are a total of 2 courses to take. To take course 1 you should have 
	finished course 0. So the correct course order is [0,1]

	4, [[1,0],[2,0],[3,1],[3,2]]
	There are a total of 4 courses to take. To take course 3 you should have 
	finished both courses 1 and 2. Both courses 1 and 2 should be taken after 
	you finished course 0. So one correct course order is [0,1,2,3]. Another 
	correct ordering is[0,2,1,3].

	Note:
	The input prerequisites is a graph represented by a list of edges, not 
	adjacency matrices. Read more about how a graph is represented.*/
	
	int * findOrder(int numCourses, int ** prerequisites, int prerequisitesRowSize, int prerequisitesColSize, int * returnSize) {
		int * Indegrees;
		int * Outdegrees;
		int ** IsConnect;
		Indegrees = (int*)malloc(sizeof(int) * numCourses);
		Outdegrees = (int*)malloc(sizeof(int) * numCourses);
		IsConnect = (int**)malloc(sizeof(int*) * numCourses);
		for (int i = 0; i < numCourses; i++) Indegrees[i] = Outdegrees[i] = 0;
		for (int i = 0; i < prerequisitesRowSize; i++) {
			Indegrees[prerequisites[i][0]]++;
			Outdegrees[prerequisites[i][1]]++;
		}
		for (int i = 0; i < numCourses; i++) {
			IsConnect[i] = (int*)malloc(sizeof(int) * (Outdegrees[i] + 1));
			IsConnect[i][0] = 0;
		}
		for (int i = 0; i < prerequisitesRowSize; i++) {
			IsConnect[prerequisites[i][1]][++IsConnect[prerequisites[i][1]][0]] = prerequisites[i][0];
		}
			
		int * Q = (int*)malloc(sizeof(int) * numCourses);
		int head = 0, tail = 0, Ans = 0;
		for (int i = 0; i < numCourses; i++) {
			if (Indegrees[i] == 0) {
				Q[tail++] = i;
				Ans++;
			}
		}
		int * Order = (int*)malloc(sizeof(int) * numCourses);
		int k = 0;
		while (head < tail) {
			for (int i = 1; i <= IsConnect[Q[head]][0]; i++) {
				Indegrees[IsConnect[Q[head]][i]]--;
				if (Indegrees[IsConnect[Q[head]][i]] == 0) {
					Q[tail++] = IsConnect[Q[head]][i];
					Ans++;
				}
			}
			Order[k++] = Q[head];
			head++;
		}
		free(Indegrees);
		free(Outdegrees);
		for (int i = 0; i < numCourses; i++) {
			free(IsConnect[i]);
		}
		free(IsConnect);
		free(Q);
		if (Ans == numCourses) {
			*returnSize = numCourses;
			return Order;
		}
		else {
			free(Order);
			*returnSize = 0;
			return NULL;
		}
	}
	
}
