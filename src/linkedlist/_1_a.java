package linkedlist;

import java.util.List;

public class _1_a {
	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(3);
		l1.next.next.next.next = new ListNode(4);
		l1.next.next.next.next.next = new ListNode(4);

		// ListNode l2 = new ListNode(0);
		// l2.next = new ListNode(5);
		// l2.next.next = new ListNode(4);
		//
		// ListNode l1 = new ListNode(5);
		//
		// ListNode l2 = new ListNode(5);

		// ListNode l1 = new ListNode(9);
		// l1.next = new ListNode(8);
		// ListNode l2 = new ListNode(1);

		// ListNode l1 = new ListNode(5);
		// ListNode l2 = new ListNode(4);

		// showListNode(l1);
		// showListNode(l2);
		_1_a obj = new _1_a();

		ListNode.showListNode(obj.deleteDuplicates(l1));

	}

	public ListNode deleteDuplicates(ListNode head) {
		  List<Integer> list=new A
	  }
}