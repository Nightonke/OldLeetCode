
public class _0206_Reverse_Linked_List {

/*	Reverse a singly linked list.*/

	struct ListNode* reverseList(struct ListNode* head) {
		struct ListNode * Before = NULL;
		struct ListNode * OriPresent = head;
		while (OriPresent != NULL) {
			struct ListNode * Present = (struct ListNode*)malloc(sizeof(struct ListNode));
			Present->val = OriPresent->val;
			Present->next = Before;
			Before = Present;
			OriPresent = OriPresent->next;
		}
		return Before;
	}
	
}
