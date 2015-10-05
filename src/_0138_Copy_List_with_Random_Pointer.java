
public class _0138_Copy_List_with_Random_Pointer {

/*	A linked list is given such that each node contains an additional random 
 *  pointer which could point to any node in the list or null.

	Return a deep copy of the list.*/
	
	/**
	 * Definition for singly-linked list with a random pointer.
	 * struct RandomListNode {
	 *     int label;
	 *     RandomListNode *next, *random;
	 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
	 * };
	 */
	class Solution {
	public:
	    RandomListNode *copyRandomList(RandomListNode *head) {
	        
	        /* exceptional case */
	        if (head == NULL) {
	            return head;
	        }
	        
	        /* exceptional case */
	        if (head->next == NULL) {
	            RandomListNode *new_head = new RandomListNode(head->label);
	            if (head->random == NULL) {
	                new_head->random = NULL;
	            } else {
	                new_head->random = new_head;
	            }
	            return new_head;
	        }
	        
	        /* form the new list which is nested in the ord one */
	        RandomListNode *make_move = head;
	        while (make_move != NULL) {
	            RandomListNode *new_node = new RandomListNode(make_move->label);
	            new_node->next = make_move->next;
	            make_move->next = new_node;
	            make_move = make_move->next->next;
	        }
	        
	        /* form the random pointers in the new list */
	        RandomListNode *pair_first = head;
	        RandomListNode *pair_second = head->next;
	        while (1) {
	            if (pair_first->random != NULL) {
	                pair_second->random = pair_first->random->next;
	            } else {
	                pair_second->random = NULL;
	            }
	            pair_first = pair_first->next->next;
	            if (pair_first == NULL) {
	                break;
	            }
	            pair_second = pair_first->next;
	        }
	        
	        /* seperate the 2 lists */
	        RandomListNode *new_head = head->next;
	        pair_first = head;
	        pair_second = new_head;
	        while (1) {
	            pair_first->next = pair_second->next;
	            pair_second->next = pair_second->next->next;
	            pair_first = pair_first->next;
	            pair_second = pair_second->next;
	            if (pair_second->next == NULL) {
	                pair_first->next = NULL;
	                break;
	            }
	        }
	        return new_head;
	    }
	};
	
}
