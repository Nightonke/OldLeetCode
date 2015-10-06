
public class _0148_Sort_List {

/*	Sort a linked list in O(n log n) time using constant space complexity.*/
	
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
	    ListNode *mergeList(ListNode *head_1, ListNode *head_2) {
	        if (head_1 == NULL) {
	            return head_2;
	        }
	        if (head_2 == NULL) {
	            return head_1;
	        }
	        ListNode *new_head;
	        if (head_1->val < head_2->val) {
	            new_head = head_1;
	            head_1 = head_1->next;
	        } else {
	            new_head = head_2;
	            head_2 = head_2->next;
	        }
	        new_head->next = mergeList(head_1, head_2);
	        return new_head;
	    }
	    
	    ListNode *sortList(ListNode *head) {
	        if (head == NULL) {
	            return NULL;
	        }
	        if (head->next == NULL) {
	            return head;
	        }
	        ListNode *sorted_head;
	        ListNode *head_front;
	        ListNode *head_back;
	        ListNode *search_1 = head;
	        ListNode *search_2 = head;
	        while (search_2->next != NULL && search_2->next->next != NULL) {
	            search_1 = search_1->next;
	            search_2 = search_2->next->next;
	        }
	        head_back = search_1->next;
	        search_1->next = NULL;
	        head_front = head;
	        sorted_head = mergeList(sortList(head_front), sortList(head_back));
	        return sorted_head;
	    }
	};
	
}
