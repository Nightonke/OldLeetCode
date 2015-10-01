
public class _0024_Swap_Nodes_in_Pairs {

/*	Given a linked list, swap every two adjacent nodes and return its head.

			For example,
			Given 1->2->3->4, you should return the list as 2->1->4->3.

			Your algorithm should use only constant space. You may not modify 
			the values in the list, only nodes itself can be changed.*/
	
	class Solution {
	public:
	    ListNode *swapPairs(ListNode *head) {
	        if (head == NULL) return head;
	        ListNode * temp = head;
	        ListNode * beforeTemp = NULL;
	        if (head->next != NULL) head = head->next;
	        while (temp != NULL && temp->next != NULL) {
	            ListNode * afterTemp = temp->next;
	            if (beforeTemp != NULL) beforeTemp->next = afterTemp;
	            temp->next = afterTemp->next;
	            afterTemp->next = temp;
	            beforeTemp = temp;
	            temp = temp->next;
	        }
	        return head;
	    }
	};
	
}
