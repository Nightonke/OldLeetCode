
public class _0019_Remove_Nth_Node_From_End_of_List {

/*	Given a linked list, remove the nth node from the end of list and return 
 *  its head.

			For example,

			   Given linked list: 1->2->3->4->5, and n = 2.

			   After removing the second node from the end, the linked list 
			   becomes 1->2->3->5.
			Note:
			Given n will always be valid.
			Try to do this in one pass.*/
	
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
	    ListNode *removeNthFromEnd(ListNode *head, int n) {
	        if (head == NULL) return head;
	        int counter = 0;
	        ListNode *temp[10000];
	        ListNode *move = head;
	        while (move) {
	            temp[counter++] = move;
	            move = move->next;
	        }
	        temp[counter] = NULL;
	        if (counter == n) {
	            delete head;
	            return temp[1];
	        }
	        temp[counter - n - 1]->next = temp[counter - n + 1];
	        return temp[0];
	    }
	};
	
}
