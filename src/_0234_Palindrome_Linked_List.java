
public class _0234_Palindrome_Linked_List {

/*	Given a singly linked list, determine if it is a palindrome.

	Follow up:
	Could you do it in O(n) time and O(1) space?*/
	
	class Solution {
	public:
	    void reverse(ListNode * head) {
	        ListNode * p1, * p2, * p3;
	        p1 = head;
	        if (p1 == NULL || p1->next == NULL) {
	            return;
	        }
	        p2 = head->next;
	        p3 = p2->next;
	        while (p2 != NULL) {
	            p2->next = p1;
	            p1 = p2;
	            p2 = p3;
	            if (p3 != NULL) {
	                p3 = p3->next;
	            }
	        }
	        head->next = NULL;
	    }
	    bool isPalindrome(ListNode * head) {
	        if (head == NULL || head->next == NULL) return true;
	        bool isP = true;
	        int count = 0;
	        ListNode * mid, * p1, * p2, * last = NULL, * beforeMid = head;
	        p1 = head;
	        p2 = head;
	        while (p2 != NULL && p2->next != NULL) {
	            count++;
	            beforeMid = p1;
	            p1 = p1->next;
	            p2 = p2->next;
	            if (p2->next == NULL) {
	                last = p2;
	            }
	            p2 = p2->next;
	            if (p2 != NULL && p2->next == NULL) {
	                last = p2;
	            }
	        }
	        mid = p1;
	        reverse(mid);
	        p1 = head;
	        p2 = last;
	        while (count--) {
	            if (p1->val != p2->val) {
	                isP = false;
	                break;
	            }
	            p1 = p1->next;
	            p2 = p2->next;
	        }
	        reverse(last);
	        beforeMid->next = mid;
	        return isP;
	    }
	};
	
}
