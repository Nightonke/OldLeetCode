
public class _0025_Reverse_Nodes_in_k_Group {

/*	Given a linked list, reverse the nodes of a linked list k at a time and 
 *  return its modified list.

			If the number of nodes is not a multiple of k then left-out nodes 
			in the end should remain as it is.

			You may not alter the values in the nodes, only nodes itself may be 
			changed.

			Only constant memory is allowed.

			For example,
			Given this linked list: 1->2->3->4->5

			For k = 2, you should return: 2->1->4->3->5

			For k = 3, you should return: 3->2->1->4->5*/
	
	class Solution {
	public:
	    ListNode *reverseKGroup(ListNode *head, int k) {
	        if (head == NULL || k < 2) return head;
	        ListNode * originalHead = head;
	        ListNode * lastTail = NULL;
	        while (1) {
	            int counter = 1;
	            ListNode * temp = originalHead;
	            while (temp && counter < k) {
	                counter++;
	                temp = temp->next;
	            }
	            if (counter == k && temp) {
	                ListNode * subHead = originalHead;
	                ListNode * nextNode = (subHead ? subHead->next : NULL);
	                ListNode * nextNext = (nextNode ? nextNode->next : NULL);
	                int times = k - 1;
	                while (times--) {
	                    nextNode->next = subHead;
	                    subHead = nextNode;
	                    nextNode = nextNext;
	                    nextNext = (nextNode ? nextNode->next : NULL);
	                }
	                if (lastTail == NULL) {
	                    head = subHead;
	                    lastTail = originalHead;
	                } else {
	                    lastTail->next = subHead;
	                    lastTail = originalHead;
	                }
	                originalHead->next = nextNode;
	                originalHead = originalHead->next;
	            } else {
	                break;
	            }
	        }
	        return head;
	    }
	};

	
}
