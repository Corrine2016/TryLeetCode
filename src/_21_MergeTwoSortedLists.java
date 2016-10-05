//Merge two sorted linked lists and return it as a new list. 
//The new list should be made by splicing together the nodes of the first two lists.
public class _21_MergeTwoSortedLists {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(6);
		// ListNode.showListNode(l1);

		ListNode l2 = new ListNode(0);
		l2.next = new ListNode(5);
		// ListNode.showListNode(l2);

		ListNode.showListNode(mergeTwoLists(l1, l2));
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode result = head;

		while (!((l1 == null) && (l2 == null))) {

			if (((l1 != null) && (l2 != null) && (l1.val <= l2.val))
					|| (l2 == null)) {

				result.next = new ListNode(l1.val);
				l1 = l1.next;

			} else if (((l1 != null) && (l2 != null) && (l2.val < l1.val))
					|| (l1 == null)) {

				result.next = new ListNode(l2.val);
				l2 = l2.next;

			}

			result = result.next;
		}
		return head.next;

	}

}
