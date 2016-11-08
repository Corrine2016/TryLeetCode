/*Given a linked list and a value x, partition it such that all nodes less than x 
come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.
For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.*/

public class _86_PartitionList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);

		ListNode.showListNode(head);
		System.out.println();
		ListNode.showListNode(partition(head, 3));

	}

	public static ListNode partition(ListNode head, int x) {
		// 1. build two empty lists
		// 2. val < x add it to the tail of first list
		// val >= x add it to the tail of second list
		// 3. concatenate the tail of list1 to the head of list2
		// 4. the tail of list2 list.next = null

		// base case
		if (head == null || head.next == null) {
			return head;
		}

		ListNode cur = head;
		ListNode dummy1 = new ListNode(0);
		ListNode head1 = dummy1;
		ListNode dummy2 = new ListNode(0);
		ListNode head2 = dummy2;
		while (cur != null) {
			if (cur.val < x) {
				dummy1.next = cur;
				dummy1 = dummy1.next;
			} else {
				dummy2.next = cur;
				dummy2 = dummy2.next;
			}
			cur = cur.next;
		}
		dummy2.next = null;
		dummy1.next = head2.next;
		return head1.next;
	}
}
