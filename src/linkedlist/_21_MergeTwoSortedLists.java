package linkedlist;
import linkedlist.ListNode;

//Merge two sorted linked lists and return it as a new list. 
//The new list should be made by splicing together the nodes of the first two lists.

/**
 * @author Corrine
 *
 */
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
		ListNode fakeHead = new ListNode(0);
		ListNode runner = fakeHead;
		ListNode r1 = l1;
		ListNode r2 = l2;
		while (r1 != null || r2 != null) {

			int cur = 0;
			if (r1 == null) {
				cur = r2.val;
				r2 = r2.next;
			} else if (r2 == null) {
				cur = r1.val;
				r1 = r1.next;
			} else {

				if (r1.val < r2.val) {
					cur = r1.val;
					r1 = r1.next;
				} else {
					cur = r2.val;
					r2 = r2.next;
				}

			}
			runner.next = new ListNode(cur);

			runner = runner.next;

		}
		return fakeHead.next;

	}

}
