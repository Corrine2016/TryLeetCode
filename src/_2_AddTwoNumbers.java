/*You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8*/

public class _2_AddTwoNumbers {
	public static void test() {
		// ListNode l1 = new ListNode(2);
		// l1.next = new ListNode(4);
		// l1.next.next = new ListNode(3);
		//
		// ListNode l2 = new ListNode(5);
		// l2.next = new ListNode(6);
		// l2.next.next = new ListNode(4);
		//
		// ListNode l1 = new ListNode(5);
		//
		// ListNode l2 = new ListNode(5);

		// ListNode l1 = new ListNode(9);
		// l1.next = new ListNode(8);
		// ListNode l2 = new ListNode(1);

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(9);
		l1.next = new ListNode(9);

		// showListNode(l1);
		// showListNode(l2);

		ListNode.showListNode(addTwoNumbers(l1, l2));

	}

	// public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	// ListNode result = new ListNode(0);
	// ListNode p = result;
	// boolean isGreaterThan9 = false;// �ж���û�г���9�����
	// while (!((l2 == null) && (l1 == null))) {
	//
	// // l2��l1��
	// if ((l1 == null) && (l2 != null)) {
	// p.val = p.val + l2.val;
	// if (p.val > 9) {
	// p.val = p.val % 10;
	// isGreaterThan9 = true;
	// } else {
	// isGreaterThan9 = false;
	// }
	//
	// l2 = l2.next;
	// if (l2 != null) {
	// if (isGreaterThan9 == true) {
	// p.next = new ListNode(1);
	// p = p.next;
	// } else {
	// p.next = new ListNode(0);
	// p = p.next;
	// }
	// }
	// }
	//
	// // l1��l2��
	// if ((l2 == null) && (l1 != null)) {
	// p.val = p.val + l1.val;
	// if (p.val > 9) {
	// p.val = p.val % 10;
	// isGreaterThan9 = true;
	// } else {
	// isGreaterThan9 = false;
	// }
	// l1 = l1.next;
	// if (l1 != null) {
	// if (isGreaterThan9 == true) {
	// p.next = new ListNode(1);
	// p = p.next;
	// } else {
	// p.next = new ListNode(0);
	// p = p.next;
	// }
	//
	// }
	// }
	//
	// if ((l2 != null) && (l1 != null)) {
	// p.val = p.val + l1.val + l2.val;
	// if (p.val > 9) {
	// p.val = p.val % 10;
	// isGreaterThan9 = true;
	// } else {
	// isGreaterThan9 = false;
	// }
	//
	// l1 = l1.next;
	//
	// l2 = l2.next;
	//
	// if (!((l2 == null) && (l1 == null))) {
	// if (isGreaterThan9 == true) {
	// p.next = new ListNode(1);
	// p = p.next;
	// } else {
	// p.next = new ListNode(0);
	// p = p.next;
	// }
	// }
	//
	// }
	// // [5,][5]->[0,1]
	// if (((l2 == null) && (l1 == null)) && (isGreaterThan9 == true)) {
	// p.next = new ListNode(1);
	// p = p.next;
	// }
	// }
	// return result;
	//
	// }

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}

}
