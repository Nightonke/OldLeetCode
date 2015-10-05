
public class _0092_Reverse_Linked_List_II {

/*	Reverse a linked list from position m to n. Do it in-place and in one-pass.

	For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4,

	return 1->4->3->2->5->NULL.

	Note:
	Given m, n satisfy the following condition:
	1 ¡Ü m ¡Ü n ¡Ü length of list.*/
	
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
	    ListNode *reverseBetween(ListNode *head, int m, int n) {
	        int pos_counter = 1;
	        ListNode *temp_move = head;
	        ListNode *temp_1;
	        ListNode *temp_2;
	        while (pos_counter <= n) {
	            if (pos_counter == m) {
	                temp_1 = temp_move;
	            }
	            if (pos_counter == n) {
	                temp_2 = temp_move;
	            }
	            pos_counter++;
	            temp_move = temp_move->next;
	        }
	        int tempInt[n - m + 1];
	        temp_move = temp_1;
	        int i = 0;
	        while (temp_2->next != temp_move) {
	            tempInt[i++] = temp_move->val;
	            temp_move = temp_move->next;
	        }
	        i--;
	        temp_move = temp_1;
	        while (temp_2->next != temp_move) {
	            temp_move->val = tempInt[i--];
	            temp_move = temp_move->next;
	        }
	        return head;
	    }
	};
	
}
