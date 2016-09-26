//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//For example,
//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3.
public class _83_RemoveDuplicatesfromSortedList {
	public static void test() {
		ListNode testList = new ListNode(1);
		testList.next = new ListNode(1);
		testList.next.next = new ListNode(2);
		testList.next.next.next = new ListNode(3);
		testList.next.next.next.next = new ListNode(3);
		// ListNode.showListNode(testList);
		ListNode.showListNode(deleteDuplicates(testList));

	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.next.val == current.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;

	}

}
