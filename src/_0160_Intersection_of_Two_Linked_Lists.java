
public class _0160_Intersection_of_Two_Linked_Lists {

/*	Write a program to find the node at which the intersection of two singly 
 *  linked lists begins.


	For example, the following two linked lists:

	A:          a1 ¡ú a2
	                   ¨K
	                     c1 ¡ú c2 ¡ú c3
	                   ¨J            
	B:     b1 ¡ú b2 ¡ú b3
	begin to intersect at node c1.


	Notes:

	If the two linked lists have no intersection at all, return null.
	The linked lists must retain their original structure after the function 
	returns.
	You may assume there are no cycles anywhere in the entire linked structure.
	Your code should preferably run in O(n) time and use only O(1) memory.
	Credits:
	Special thanks to @stellari for adding this problem and creating all test 
	cases.*/

	class Solution {
	public:
	    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
	        ListNode * a, * b;
	        bool aMeetNull, bMeetNull;
	        a = headA;
	        b = headB;
	        aMeetNull = bMeetNull = false;
	        while (1) {
	            if (!a && !aMeetNull) a = headB, aMeetNull = true;
	            if (!b && !bMeetNull) b = headA, bMeetNull = true;
	            if (!a && aMeetNull) return NULL;
	            if (aMeetNull && bMeetNull && a->val == b->val) return a;
	            a = a->next;
	            b = b->next;
	        }
	    }
	};
	
}
