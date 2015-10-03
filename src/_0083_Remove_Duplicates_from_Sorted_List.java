
public class _0083_Remove_Duplicates_from_Sorted_List {

/*	Given a sorted linked list, delete all duplicates such that each element 
 *  appear only once.

	For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.*/
	
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
	    ListNode *deleteDuplicates(ListNode *head) {
	        if (head == NULL || head->next == NULL) {
	            return head;
	        }
	        ListNode *before = head;
	        ListNode *after = head->next;
	        while (after != NULL) {
	            while (before->val == after->val) {
	                before->next = after->next;
	                delete after;
	                after = before->next;
	                if (after == NULL) {
	                    return head;
	                }
	            }
	            
	            before = before->next;
	            after = after->next;
	        }
	        return head;
	    }
	};
	
}
