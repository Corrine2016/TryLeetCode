import java.util.ArrayList;
import java.util.List;

/*Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].*/

/**
 * @author corrine
 *
 */
public class _145_BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(res, root);
		return res;

	}

	private void helper(List<Integer> res, TreeNode root) {
		if (root == null)
			return;
		else {
			helper(res, root.left);
			helper(res, root.right);
			res.add(root.val);
		}

	}

}
