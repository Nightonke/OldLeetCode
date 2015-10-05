
public class _0086_Partition_List {

/*	Given a linked list and a value x, partition it such that all nodes less 
 *  than x come before nodes greater than or equal to x.

	You should preserve the original relative order of the nodes in each of the 
	two partitions.

	For example,
	Given 1->4->3->2->5->2 and x = 3,
	return 1->2->2->4->3->5.*/
	
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
	    ListNode *partition(ListNode *head, int x) {
	        if (head == NULL) {
	            return head;
	        }
	        if (head->next == NULL) {
	            return head;
	        }
	        bool first_less = true;
	        bool first_greater = true;
	        ListNode *less_head = NULL;
	        ListNode *less_tail = NULL;
	        ListNode *greater_head = NULL;
	        ListNode *greater_tail = NULL;
	        ListNode *move = head;
	        while (move != NULL) {
	            if (move->val < x) {
	                if (first_less) {
	                    first_less = false;
	                    less_head = new ListNode(move->val);
	                    less_tail = less_head;
	                } else {
	                    ListNode *new_less = new ListNode(move->val);
	                    less_tail->next = new_less;
	                    less_tail = less_tail->next;
	                }
	            } else {
	                if (first_greater) {
	                    first_greater = false;
	                    greater_head = new ListNode(move->val);
	                    greater_tail = greater_head;
	                } else {
	                    ListNode *new_greater = new ListNode(move->val);
	                    greater_tail->next = new_greater;
	                    greater_tail = greater_tail->next;
	                }
	            }
	            move = move->next;
	        }
	        move = head;
	        ListNode *move_new = less_head;
	        ListNode *del;
	        while (move_new != NULL) {
	            move->val = move_new->val;
	            move = move->next;
	            del = move_new;
	            move_new = move_new->next;
	            delete del;
	        }
	        move_new = greater_head;
	        while (move_new != NULL) {
	            move->val = move_new->val;
	            move = move->next;
	            del = move_new;
	            move_new = move_new->next;
	            delete del;
	        }
	        return head;
	    }
	};
	
}
