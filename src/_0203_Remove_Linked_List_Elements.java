
public class _0203_Remove_Linked_List_Elements {

/*	Remove all elements from a linked list of integers that have value val.

	Example
	Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
	Return: 1 --> 2 --> 3 --> 4 --> 5*/
	
	struct ListNode * removeElements(struct ListNode * head, int val) {
		struct ListNode BeforeHead;
		struct ListNode * temp1 = head, *temp2 = &BeforeHead;
		BeforeHead.next = head;
		while (temp1 != NULL) {
			if (temp1->val != val) {
				temp2->next = temp1;
				temp2 = temp2->next;
			}
			temp1 = temp1->next;
		}
		temp2->next = NULL;
		return BeforeHead.next;
	}
	
}
