import java.util.ArrayList;
import java.util.List;

/*Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

*/
public class _94_BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		inorder(root, res);
		return res;
	}

	private void inorder(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		else {
			if (root.left != null)
				inorder(root.left, res);
			res.add(root.val);

			if (root.right != null)
				inorder(root.right, res);

		}
	}
}
