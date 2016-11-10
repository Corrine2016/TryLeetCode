import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*Given a binary tree, return the zigzag level order traversal of its nodes' 
		values. (ie, from left to right, then right to left for the next
				level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]*/
public class _103_BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		} else {

			List<TreeNode> list = new ArrayList<TreeNode>();
			boolean isZig = true;
			list.add(root);
			traversal(res, list, isZig);
			return res;
		}
	}

	private void traversal(List<List<Integer>> res, List<TreeNode> list, boolean isZig) {
		if (!list.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			List<TreeNode> newList = new ArrayList<TreeNode>();

			while (!list.isEmpty()) {
				TreeNode cur = list.remove(0);
				temp.add(cur.val);
				if (cur.left != null)
					newList.add(cur.left);
				if (cur.right != null)
					newList.add(cur.right);
			}
			if (!isZig)
				Collections.reverse(temp);
			isZig = !isZig;
			res.add(temp);
			traversal(res, newList, isZig);
		} else
			return;
	}
}
