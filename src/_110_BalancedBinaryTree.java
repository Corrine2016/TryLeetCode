//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two 
//subtrees of every node never differ by more than 1.

//ƽ���������Balanced Binary Tree���ֱ���ΪAVL�����б���AVL�㷨��������һ�ÿ������������������������ĸ߶Ȳ�ľ���ֵ������1����������������������һ��ƽ���������
public class _110_BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		else if (Math.abs(depth(root.left) - depth(root.right)) > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}

	private int depth(TreeNode root) {
		if (root == null)
			return 0;
		else
			return 1 + Math.max(depth(root.left), depth(root.right));

	}
}
