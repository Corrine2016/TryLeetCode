/*Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5*/
public class _203_RemoveLinkedListElements {
	public static void main(String[] args) {
		ListNode testList = new ListNode(1);
		testList.next = new ListNode(1);
		testList.next.next = new ListNode(2);
		testList.next.next.next = new ListNode(3);
		testList.next.next.next.next = new ListNode(3);
		// ListNode.showListNode(testList);
		ListNode.showListNode(removeElements(testList, 1));

	}

	public static ListNode removeElements(ListNode head, int val) {
		if (head == null || head.next == null && head.val == val) {
			return null;
		}
		if (head.next == null && head.val != val) {
			return head;
		}
		// Keep removing head until head.val!=val
		while (head != null && head.val == val)
			head = head.next;

		ListNode curr = head;

		while (curr != null) {
			if (curr.next != null && curr.next.val == val) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
		return head;
	}
}
