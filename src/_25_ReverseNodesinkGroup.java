import linkedlist.ListNode;

/*Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5*/

/**
 * @author Corrine
 *
 */
public class _25_ReverseNodesinkGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode start = fakeHead;
		int epoch = 0;
		while (!isLessThanK(start, k)) {
			// System.out.println(isLessThanK(start, k));
			// System.out.println(epoch);
			int count = 0;
			ListNode r1 = start;
			ListNode startNext = start.next;
			while (count < k) {
				r1 = r1.next;
				count++;
			}
			ListNode end = r1.next;
			r1.next = null;
			start.next = null;

			start.next = reverseList(startNext);
			startNext.next = end;
			start = startNext;
			// ListNode.showListNode(fakeHead.next);
			epoch++;

		}

		return fakeHead.next;

	}

	private boolean isLessThanK(ListNode start, int k) {
		int count = 0;
		ListNode runner = start;
		while (runner != null) {

			runner = runner.next;
			count++;
		}
		return count - 1 < k;

	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = head;
		ListNode cur = head.next;
		head.next = null;
		while (cur != null) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
	}
}
