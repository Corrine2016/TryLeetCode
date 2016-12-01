import java.util.ArrayList;
import java.util.List;

/*Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].*/

/**
 * @author corrine
 *
 */
public class _199_BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
		temp.add(root);
		helper(res, temp);

		return res;
	}

	private void helper(List<Integer> res, ArrayList<TreeNode> temp) {

		if (temp.isEmpty())
			return;
		else {
			res.add(temp.get(temp.size() - 1).val);
			ArrayList<TreeNode> newTemp = new ArrayList<TreeNode>();
			for (int i = 0; i < temp.size(); i++) {
				TreeNode left = temp.get(i).left;
				TreeNode right = temp.get(i).right;
				if (left != null)
					newTemp.add(left);
				if (right != null)
					newTemp.add(right);
			}
			helper(res, newTemp);
		}

	}
}
