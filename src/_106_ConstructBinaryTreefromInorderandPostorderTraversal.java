//Given inorder and postorder traversal of a tree, construct the binary tree.

public class _106_ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
	}

	public TreeNode helper(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
		if (postStart < 0 || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postStart]);
		int inIndex = 0; // Index of current root in inorder
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root.val) {
				inIndex = i;
			}
		}
		root.left = helper(postStart + inIndex - inEnd - 1, inStart, inIndex - 1, postorder, inorder);
		root.right = helper(postStart - 1, inIndex + 1, inEnd, postorder, inorder);
		return root;

	}
}
