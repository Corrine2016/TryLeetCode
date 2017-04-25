package linkedlist;
import linkedlist.ListNode;

/*Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, 
 only nodes itself can be changed.

 Subscribe to see which companies asked this question*/

/**
 * @author Corrine
 *
 */
public class _24_SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode runner = fakeHead;

		ListNode before = head;
		ListNode after = head.next;
		while (runner != null && runner.next != null
				&& runner.next.next != null) {
			before = runner.next;

			after = before.next;

			ListNode temp = after.next;
			runner.next = after;
			after.next = before;
			before.next = temp;
			runner = before;

		}

		return fakeHead.next;

	}

}
