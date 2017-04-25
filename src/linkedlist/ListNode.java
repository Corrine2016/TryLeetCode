package linkedlist;

public class ListNode {

	public static void showListNode(ListNode l1) {
		while (l1 != null) {
			System.out.print(l1.val + " ");
			l1 = l1.next;

		}
	}

	public int val;

	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
}
