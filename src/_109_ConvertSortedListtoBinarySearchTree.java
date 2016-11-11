//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

public class _109_ConvertSortedListtoBinarySearchTree {

	public TreeNode sortedListToBST(ListNode head) {
		return sortedListToBST(head, null);
	}

	public TreeNode sortedListToBST(ListNode head, ListNode end) { // BST tree
																	// from head
																	// to end
		if (head == end)
			return null;
		ListNode slow = head, fast = head; // slow is the middle point of list
											// from head to end
		while (fast.next != end && fast.next.next != end) {
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST(head, slow);
		root.right = sortedListToBST(slow.next, end);
		return root;
	}
}
