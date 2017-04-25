package linkedlist;
import linkedlist.ListNode;

//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//For example,
//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3.

/**
 * @author Corrine
 *
 */
public class _83_RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			ListNode runner = cur.next;
			while (runner != null && runner.val == cur.val) {
				runner = runner.next;
			}
			cur.next = runner;
			cur = runner;
		}
		return head;
	}

}
