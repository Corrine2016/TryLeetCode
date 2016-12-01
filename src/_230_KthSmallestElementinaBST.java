/*Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
Credits:*/

/**
 * @author corrine
 *
 */
public class _230_KthSmallestElementinaBST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		TreeNode r2 = root.left;

		root.right = new TreeNode(8);
		TreeNode r3 = root.right;

		root.left.left = new TreeNode(0);
		TreeNode r4 = root.left.left;

		root.left.right = new TreeNode(4);
		TreeNode r5 = root.left.right;
		System.out.println(countNode(root.left));
		System.out.println(kthSmallest(root, 4));
	}

	public static int kthSmallest(TreeNode root, int k) {
		int numLeft = countNode(root.left);
		if (k == numLeft + 1)
			return root.val;
		else if (k <= numLeft)
			return kthSmallest(root.left, k);
		else
			return kthSmallest(root.right, k - numLeft - 1);
	}

	private static int countNode(TreeNode root) {
		int sum = 0;
		if (root == null)
			return 0;
		sum++;
		if (root.left != null)
			sum += countNode(root.left);
		if (root.right != null)
			sum += countNode(root.right);
		return sum;

	}

}
