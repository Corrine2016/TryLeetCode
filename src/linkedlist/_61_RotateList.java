package linkedlist;
/*Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.*/

//https://discuss.leetcode.com/topic/50800/java-easy-solution-with-explanation
public class _61_RotateList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode.showListNode(head);
		System.out.println();
		ListNode.showListNode(rotateRight(head, 7));

	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (k <= 0 || head == null || head.next == null) {
			return head;
		}
		ListNode oldHead = head;

		ListNode slow = head;

		ListNode cur = head;
		int length = 0;

		while (cur != null) {
			cur = cur.next;
			length++;
		}
		if (k % length == 0) {
			return head;
		}

		cur = head;
		for (int i = 0; i < k % length; ++i) {
			cur = cur.next;
		}
		while (cur != null && cur.next != null) {
			slow = slow.next;
			cur = cur.next;
		}
		ListNode newHead = slow.next;
		cur.next = oldHead;
		slow.next = null;
		return newHead;
	}
}
