/*Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, 
only nodes itself can be changed.

Subscribe to see which companies asked this question*/

public class _24_SwapNodesinPairs {
	public static void test() {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		// l1.next.next.next.next = new ListNode(5);
		// ListNode.showListNode(l1);
		ListNode.showListNode(swapPairs(l1));
	}

	public static ListNode swapPairs(ListNode head) {
		// 0个点，1个点
		if ((head == null) || (head.next == null))
			return head;

		ListNode runnerBefore = head;
		ListNode runnerAfter = head.next;

		while (runnerAfter != null) {
			int temp = runnerAfter.val;
			runnerAfter.val = runnerBefore.val;
			runnerBefore.val = temp;
			// runnerAfter.next==null等价于下轮的before和after都没有
			if (runnerAfter.next == null) {
				return head;
			}

			runnerBefore = runnerBefore.next.next;
			runnerAfter = runnerAfter.next.next;

		}
		return head;

	}

}
