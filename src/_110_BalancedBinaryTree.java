//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two 
//subtrees of every node never differ by more than 1.

//平衡二叉树（Balanced Binary Tree）又被称为AVL树（有别于AVL算法），它是一棵空树，或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
public class _110_BalancedBinaryTree {
	private int depth(TreeNode root) {
		if (root == null)
			return 0;
		else
			return 1 + Math.max(depth(root.left), depth(root.right));

	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		else if (Math.abs(depth(root.left) - depth(root.right)) > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}
}
