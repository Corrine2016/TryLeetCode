//Given two binary trees, write a function to check if they are equal or not.
//
//Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
public class _100_SameTree {

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if ((p == null && q != null) || (p != null && q == null))
			return false;
		else {
			if (p.val != q.val) {
				return false;
			} else {
				return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
			}
		}
	}
}
