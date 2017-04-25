package linkedlist;
import linkedlist.ListNode;

/*Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.*/

/**
 * @author Corrine
 *
 */
public class _92_ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode fakehead = new ListNode(0);
		fakehead.next = head;
		ListNode runner = fakehead;
		int count = 0;
		while (count < m - 1) {
			runner = runner.next;
			count++;
		}
		System.out.println(runner.val);
		ListNode start = runner.next;
		ListNode pre = runner.next;
		if (pre.next == null)
			return head;
		ListNode cur = pre.next;
		while (count < n - 1 && cur != null) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
			count++;
		}
		runner.next = pre;
		start.next = cur;
		return fakehead.next;

	}
}
