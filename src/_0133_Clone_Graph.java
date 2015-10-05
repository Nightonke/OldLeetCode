
public class _0133_Clone_Graph {

/*	Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


	OJ's undirected graph serialization:
	Nodes are labeled uniquely.

	We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
	As an example, consider the serialized graph {0,1,2#1,2#2,2}.

	The graph has a total of three nodes, and therefore contains three parts as separated by #.

	First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
	Second node is labeled as 1. Connect node 1 to node 2.
	Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
	Visually, the graph looks like the following:

	       1
	      / \
	     /   \
	    0 --- 2
	         / \
	         \_/*/
	
	class Solution {
	  public:
	    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
	        if (node == NULL) return node;
	        queue<UndirectedGraphNode * > q;
	        map<int, UndirectedGraphNode * > m;  // store the node made to check if a node exists
	        q.push(node);  // store the node existed to bfs(my thought)
	        while (!q.empty()) {
	            UndirectedGraphNode * temp = q.front();
	            q.pop();
	            if (m.find(temp->label) == m.end()) {  // it is new node
	                m[temp->label] = new UndirectedGraphNode(temp->label);
	            }
	            map<int, UndirectedGraphNode * >::iterator tempMade = m.find(temp->label);  // find the corresponding node made
	            for (int i = 0; i < temp->neighbors.size(); i++) {
	                map<int, UndirectedGraphNode * >::iterator son = m.find(temp->neighbors[i]->label);
	                UndirectedGraphNode * newSon = son->second;  // ready for pushing back, if son is end(), newSon would be changed later
	                if (son == m.end()) {  // new node
	                    newSon = new UndirectedGraphNode(temp->neighbors[i]->label);  // make a new one
	                    m[temp->neighbors[i]->label] = newSon;  // the new node now is an old one
	                    q.push(temp->neighbors[i]);
	                }
	                tempMade->second->neighbors.push_back(newSon);
	            }
	        }
	        return m.find(node->label)->second;
	    }
	};
	
}
