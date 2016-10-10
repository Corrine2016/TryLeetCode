/*Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1*/
public class _226_InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		else {
			if (root.right == null && root.left != null) {
				root.right = invertTree(root.left);
				root.left = null;
			} else if (root.right != null && root.left == null) {
				root.left = invertTree(root.right);
				root.right = null;
			} else {
				TreeNode temp = new TreeNode(0);
				temp = root.left;
				root.left = invertTree(root.right);
				root.right = invertTree(temp);
			}
			return root;
		}

	}
}
