import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return the level order traversal of its nodes' values. 
//(ie, from left to right, level by level).
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its level order traversal as:
//[
//  [3],
//  [9,20],
//  [15,7]
//]
public class _102_BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		levelRecursion(root, result, 0);

		return result;
	}

	/**
	 * 递归方法
	 */
	private void levelRecursion(TreeNode node, List<List<Integer>> result, int level) {
		if (node == null) {
			return;
		}
		if (result.size() < level + 1) {// 说明还需要添加一行
			result.add(new ArrayList<Integer>());
		}
		result.get(level).add(node.val);

		levelRecursion(node.left, result, level + 1);
		levelRecursion(node.right, result, level + 1);
	}
}
