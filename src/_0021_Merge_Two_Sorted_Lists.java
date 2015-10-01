
public class _0021_Merge_Two_Sorted_Lists {

/*	Merge two sorted linked lists and return it as a new list. The new list 
 *  should be made by splicing together the nodes of the first two lists.*/
	
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
	    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
	        if (l1 == NULL) {
	            return l2;
	        }
	        if (l2 == NULL) {
	            return l1;
	        }
	        ListNode *new_head;
	        ListNode *move_1 = l1;
	        ListNode *move_2 = l2;
	        ListNode *move_3;
	        if (l1->val < l2->val) {
	            new_head = new ListNode(l1->val);
	            move_1 = move_1->next;
	        } else {
	            new_head = new ListNode(l2->val);
	            move_2 = move_2->next;
	        }
	        move_3 = new_head;
	        while (move_1 || move_2) {
	            if (move_1 && ((move_2 == NULL) || (move_1->val < move_2->val))) {
	                move_3->next = new ListNode(move_1->val);
	                move_1 = move_1->next;
	            } else if (move_2 && ((move_1 == NULL) || (move_1->val >= move_2->val))) {
	                move_3->next = new ListNode(move_2->val);
	                move_2 = move_2->next;
	            }
	            move_3 = move_3->next;
	        }
	        return new_head;
	    }
	};
}
