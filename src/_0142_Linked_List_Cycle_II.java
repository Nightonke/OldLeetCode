
public class _0142_Linked_List_Cycle_II {

/*	Given a linked list, return the node where the cycle begins. If there is no 
 *  cycle, return null.

	Note: Do not modify the linked list.

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
	    ListNode *detectCycle(ListNode *head) {
	        ListNode *temp_1 = head;
	        ListNode *temp_2 = head;
	        ListNode *meetPoint;
	        bool loop = false;
	        while (temp_2 != NULL && temp_2->next != NULL) {
	            temp_1 = temp_1->next;
	            temp_2 = temp_2->next->next;
	            if (temp_1 == temp_2) {
	                meetPoint = temp_1;
	                loop = true;
	                break;
	            }
	        }
	        if (!loop) {
	            return NULL;
	        } else {
	            temp_1 = head;
	            temp_2 = meetPoint;
	            while (temp_1 != temp_2) {
	                temp_1 = temp_1->next;
	                temp_2 = temp_2->next;
	            }
	            return temp_1;
	        }
	    }
	};
	
}
