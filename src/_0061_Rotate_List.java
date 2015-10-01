
public class _0061_Rotate_List {

/*	Given a list, rotate the list to the right by k places, where k is 
 *  non-negative.

	For example:
	Given 1->2->3->4->5->NULL and k = 2,
	return 4->5->1->2->3->NULL.*/
	
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
	    ListNode *rotateRight(ListNode *head, int k) {
	        if (head == NULL || head->next == NULL || k == 0) return head;
	        int counter = 0;
	        ListNode *move = head;
	        while (move) {
	            counter++;
	            move = move->next;
	        }
	        k %= counter;
	        if (k == 0) return head;
	        move = head;
	        counter -= k + 1;
	        while (counter) {
	            counter--;
	            move = move->next;
	        }
	        ListNode *break_point = move->next;
	        move->next = NULL;
	        move = break_point;
	        while (move->next) {
	            move = move->next;
	        }
	        move->next = head;
	        return break_point;
	    }
	};
	
}
