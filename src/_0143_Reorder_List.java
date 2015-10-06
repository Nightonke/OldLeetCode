
public class _0143_Reorder_List {

/*	Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
	reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­

	You must do this in-place without altering the nodes' values.

	For example,
	Given {1,2,3,4}, reorder it to {1,4,2,3}.*/
	
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
	    void reorderList(ListNode *head) {
	        if (head == NULL) {
	            return;
	        }
	        int counter = 0;
	        ListNode *move = head;
	        while (move != NULL) {
	            move = move->next;
	            counter++;
	        }
	        ListNode* ln[counter];
	        move = head;
	        int i = 0;
	        while (move != NULL) {
	            ln[i++] = move;
	            move = move->next;
	        }
	        int counter_2 = 0;
	        int pos_1 = 0;
	        int pos_2 = counter - 1;
	        int h = 0;
	        int t = counter - 1;
	        int half = counter / 2;
	        while (counter_2 < counter) {
	            ln[pos_1]->next = ln[pos_2];
	            pos_1 = pos_2;
	            if (pos_2 > half) {
	                h++;
	                pos_2 = h;
	            } else {
	                t--;
	                pos_2 = t;
	            }
	            counter_2++;
	        }
	        ln[half]->next = NULL;
	    }
	};
	
}
