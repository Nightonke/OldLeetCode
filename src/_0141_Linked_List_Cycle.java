
public class _0141_Linked_List_Cycle {

/*	Given a linked list, determine if it has a cycle in it.

	Follow up:
	Can you solve it without using extra space?*/
	
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
	    bool hasCycle(ListNode *head) {
	        ListNode *temp_1 = head;
	        ListNode *temp_2 = head;
	        while (temp_2 != NULL && temp_2->next != NULL) {
	            temp_1 = temp_1->next;
	            temp_2 = temp_2->next->next;
	            if (temp_1 == temp_2) {
	                return true;
	            }
	        }
	        return false;
	    }
	};
	
}
