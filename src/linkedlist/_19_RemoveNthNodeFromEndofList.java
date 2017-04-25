package linkedlist;
/*Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.*/

/**
 * @author Corrine
 *
 */
public class _19_RemoveNthNodeFromEndofList {
	public static void main(String[] args) {
		ListNode testList = new ListNode(1);
		testList.next = new ListNode(2);
		testList.next.next = new ListNode(3);
		testList.next.next.next = new ListNode(4);
		testList.next.next.next.next = new ListNode(5);
		ListNode.showListNode(testList);
		ListNode.showListNode(removeNthFromEnd(testList, 2));

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode runner = head;
		for (int i = 0; i < n; i++) {
			runner = runner.next;
		}
		if (runner == null) {
			return head.next;
		}
		ListNode secRunner = head;
		while (runner.next != null) {
			secRunner = secRunner.next;
			runner = runner.next;
		}
		secRunner.next = secRunner.next.next;
		return head;

	}
}
