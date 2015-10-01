
public class _0023_Merge_k_Sorted_Lists {

/*	Merge k sorted linked lists and return it as one sorted list. Analyze and 
 * describe its complexity.*/
	
	/**
	 * Definition for singly-linked list.
	 * struct ListNode {
	 *     int val;
	 *     ListNode *next;
	 *     ListNode(int x) : val(x), next(NULL) {}
	 * };
	 */
	class Solution {
	public:
	    ListNode *mergeKLists(vector<ListNode *> &lists) {
	        if (lists.size() == 0) return NULL;
	        if (lists.size() == 1) return lists[0];
	        ListNode *new_head = NULL;
	        ListNode *move;
	        bool is_head = true;  // weather to make the head of the return list
	        while (1) {
	            bool is_empty = true;  // to see if it's empty(all NULL)
	            int min;
	            int mem;
	            int i;
	            int j;
	            for (i = 0; i < lists.size(); i++) {  // find the first val
	                if (lists[i] != NULL) {
	                    is_empty = false;
	                    min = lists[i]->val;
	                    mem = i;
	                    break;
	                }
	            }
	            if (is_empty) {  // notice that lists may be {NULL, NULL}, so the initial value of new_head is NULL
	                return new_head;
	            }
	            for (j = i + 1; j < lists.size(); j++) {  // find the min val and the pos
	                if (lists[j] && lists[j]->val < min) {
	                    min = lists[j]->val;
	                    mem = j;
	                }
	            }
	            if (is_head) {
	                is_head = false;
	                new_head = new ListNode(min);
	                move = new_head;
	            } else {
	                ListNode *new_node = new ListNode(min);
	                move->next = new_node;
	                move = move->next;
	            }
	            ListNode *del = lists[mem];
	            lists[mem] = lists[mem]->next;
	            delete del;
	        }
	    }
	};
	
}
