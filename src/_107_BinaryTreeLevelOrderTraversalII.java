import java.util.LinkedList;
import java.util.List;

//Given a binary tree, return the bottom-up level order traversal of its nodes' values.
//(ie, from left to right, level by level from leaf to root).
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its bottom-up level order traversal as:
//[
//  [15,7],
//  [9,20],
//  [3]
//]
public class _107_BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		addLevel(root, result, 0);
		return result;
	}

	private void addLevel(TreeNode node, LinkedList<List<Integer>> result, int level) {
		if (node == null)
			return;
		if (result.size() < level + 1)
			result.addFirst(new LinkedList<Integer>());
		result.get(result.size() - 1 - level).add(node.val);
		addLevel(node.left, result, level + 1);
		addLevel(node.right, result, level + 1);
	}
}
