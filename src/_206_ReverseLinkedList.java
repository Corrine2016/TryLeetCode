import java.util.Stack;

//Reverse a singly linked list.
public class _206_ReverseLinkedList {
	public static void main(String[] args) {
		ListNode testList = new ListNode(1);
		testList.next = new ListNode(2);
		testList.next.next = new ListNode(3);
		testList.next.next.next = new ListNode(4);
		testList.next.next.next.next = new ListNode(5);
		// ListNode.showListNode(testList);
		ListNode.showListNode(reverseList(testList));

	}

	public static ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		Stack<Integer> stack = new Stack<>();
		while (head.next != null) {
			stack.push(head.val);
			head = head.next;
		}

		head = new ListNode(head.val);
		ListNode runner = head;
		while (!stack.isEmpty()) {

			runner.next = new ListNode(stack.pop());
			runner = runner.next;

		}
		return head;

	}
}
