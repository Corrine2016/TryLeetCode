package linkedlist;
import linkedlist.ListNode;

//Reverse a singly linked list.
/**
 * @author Corrine
 *
 */
public class _206_ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = head;
		ListNode cur = head.next;
		head.next = null;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
	}
}
