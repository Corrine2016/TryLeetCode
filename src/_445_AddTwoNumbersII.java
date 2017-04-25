import java.util.Stack;

import linkedlist.ListNode;

/*You are given two linked lists representing two non-negative numbers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Follow up:
 What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

 Example:

 Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 8 -> 0 -> 7*/
//answer
public class _445_AddTwoNumbersII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> stack3 = new Stack<Integer>();
		ListNode r1 = l1;
		while (r1 != null) {
			stack1.push(r1.val);
			r1 = r1.next;
		}
		ListNode r2 = l2;
		while (r2 != null) {
			stack2.push(r2.val);
			r2 = r2.next;
		}
		int sum = 0, carry = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			int num1 = stack1.isEmpty() ? 0 : stack1.pop();
			int num2 = stack2.isEmpty() ? 0 : stack2.pop();
			sum = num1 + num2 + carry;
			stack3.push(sum % 10);
			carry = sum / 10;
		}
		if (carry != 0)
			stack3.push(carry);
		ListNode l3 = new ListNode(0);
		ListNode r3 = l3;
		while (!stack3.isEmpty()) {
			r3.next = new ListNode(stack3.pop());
			r3 = r3.next;
		}
		return l3.next;

	}
}
