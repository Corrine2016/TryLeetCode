package linkedlist;
/*You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8*/

/**
 * @author Corrine
 *
 */
public class _2_AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode r1 = l1;
		ListNode r2 = l2;
		ListNode l3 = new ListNode(0);
		ListNode r3 = l3;
		int sum = 0;
		int over = 0;
		while (r1 != null || r2 != null) {

			int num1 = r1 == null ? 0 : r1.val;
			int num2 = r2 == null ? 0 : r2.val;
			sum = (num1 + num2 + over) % 10;

			over = (num1 + num2 + over) / 10;
			r3.next = new ListNode(sum);
			if (r1 != null)
				r1 = r1.next;
			if (r2 != null)
				r2 = r2.next;
			r3 = r3.next;
		}
		if (r1 == null && r2 == null && over != 0)
			r3.next = new ListNode(over);
		return l3.next;
	}

}
