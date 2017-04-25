package linkedlist;
import linkedlist.ListNode;

/*Given a linked list and a value x, partition it such that all nodes less than x 
 come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.
 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.*/

/**
 * @author Corrine
 *
 */
public class _86_PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode less = new ListNode(0);
		ListNode more = new ListNode(0);
		ListNode runner = head;
		ListNode rLess = less;
		ListNode rMore = more;
		while (runner != null) {
			if (runner.val < x) {
				rLess.next = new ListNode(runner.val);
				rLess = rLess.next;
			}

			else {
				rMore.next = new ListNode(runner.val);
				rMore = rMore.next;
			}
			runner = runner.next;
		}
		rLess.next = more.next;
		return less.next;
	}
}
