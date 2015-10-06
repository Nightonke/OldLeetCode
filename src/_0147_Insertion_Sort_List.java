
public class _0147_Insertion_Sort_List {

/*	Sort a linked list using insertion sort.*/
	
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
	    ListNode *insertionSortList(ListNode *head) {
	        for (ListNode *temp_1 = head; temp_1 != NULL; temp_1 = temp_1->next) {
	            int min = temp_1->val;
	            ListNode *remem = temp_1;
	            for (ListNode *temp_2 = temp_1->next; temp_2 != NULL; temp_2 = temp_2->next) {
	                if (temp_2->val < min) {
	                    min = temp_2->val;
	                    remem = temp_2;
	                }
	            }
	            remem->val = temp_1->val;
	            temp_1->val = min;
	        }
	        return head;
	    }
	};
	
}
