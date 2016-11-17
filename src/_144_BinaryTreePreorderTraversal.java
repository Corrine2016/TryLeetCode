import java.util.ArrayList;
import java.util.List;

/*Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].*/

/**
 * @author corrine
 *
 */
public class _144_BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;

	}

	private void helper(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		else {
			res.add(root.val);
			helper(root.left, res);
			helper(root.right, res);
		}

	}
}
