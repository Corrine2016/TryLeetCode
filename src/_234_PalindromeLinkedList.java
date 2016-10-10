import java.util.Stack;

/*Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?*/
public class _234_PalindromeLinkedList {
	public static void main(String[] args) {
		ListNode testList = new ListNode(1);
		testList.next = new ListNode(2);
		testList.next.next = new ListNode(3);
		testList.next.next.next = new ListNode(2);
		testList.next.next.next.next = new ListNode(1);
		// ListNode.showListNode(testList);
		System.out.println(isPalindrome(testList));

	}

	public static boolean isPalindrome(ListNode head) {

		Stack<Integer> stack = new Stack<>();
		ListNode runner = head;
		while (runner != null) {
			stack.push(runner.val);
			runner = runner.next;
		}
		System.out.println(stack);
		ListNode runner2 = head;
		while (runner2 != null) {
			if (runner2.val != stack.pop())
				return false;
			runner2 = runner2.next;
		}

		return true;
	}
}
