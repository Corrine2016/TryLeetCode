
public class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static void showListNode(ListNode l1) {
		while (l1 != null) {
			System.out.println(l1.val);
			l1 = l1.next;

		}
	}
}
