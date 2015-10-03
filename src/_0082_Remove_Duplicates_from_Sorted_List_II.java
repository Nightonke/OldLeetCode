
public class _0082_Remove_Duplicates_from_Sorted_List_II {

/*	Given a sorted linked list, delete all nodes that have duplicate numbers, 
 *  leaving only distinct numbers from the original list.

	For example,
	Given 1->2->3->3->4->4->5, return 1->2->5.
	Given 1->1->1->2->3, return 2->3.*/

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
	        ListNode *temp;
	        ListNode *before_temp;
	        ListNode *new_head = head;
	        int to_delete_int;
	        
	        if (head == NULL) {
	            return NULL;
	        }
	        
	        //the specil solution of the duplicates in head:
	        while (head->next != NULL && head->val == head->next->val) {
	            to_delete_int = head->val;
	            ListNode *to_delete = head;
	            while (to_delete != NULL && to_delete_int == to_delete->val) {
	                ListNode *before_to_delete = to_delete;
	                to_delete = to_delete->next;
	                delete before_to_delete;
	            }
	            if (to_delete == NULL) {
	                return NULL;
	            }
	            head = to_delete;
	        }
	        new_head = head;
	        temp = head;
	        
	        while (temp->next != NULL) {
	            if (temp->val == temp->next->val) {
	                to_delete_int = temp->val;
	                ListNode *to_delete = temp;
	                while (to_delete != NULL && to_delete_int == to_delete->val) {
	                    ListNode *before_to_delete = to_delete;
	                    to_delete = to_delete->next;
	                    delete before_to_delete;
	                }
	                if (to_delete == NULL) {
	                    before_temp->next = NULL;
	                    return new_head;
	                }
	                temp = to_delete;
	                before_temp->next = temp;
	            } else {
	                before_temp = temp;
	                temp = temp->next;
	            }
	        }
	        return new_head;
	    }
	};
	
}
