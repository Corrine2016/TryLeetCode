/*Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
*/

/**
 * @author corrine
 *
 */
public class _328_OddEvenLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode.showListNode(head);
		System.out.println();
		ListNode.showListNode(oddEvenList(head));

	}

	public static ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode s1 = head;
		ListNode s2 = head.next;

		ListNode r1 = s1;
		ListNode r2 = s2;
		while (r1.next != null && r2.next != null) {
			r1.next = r2.next;
			r2.next = r2.next.next;
			r1 = r1.next;
			r2 = r2.next;
		}
		r1.next = s2;
		return s1;

	}
}
