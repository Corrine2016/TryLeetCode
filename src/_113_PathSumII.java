import java.util.ArrayList;
import java.util.List;

//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//return
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
public class _113_PathSumII {
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		if (root == null) {
			return result;
		}
		pathSum(root, sum, new ArrayList<>(), 0);
		return result;
	}

	public void pathSum(TreeNode root, int target, List<Integer> list, int currentSum) {
		list.add(root.val);
		currentSum += root.val;
		if (root.left == null && root.right == null && currentSum == target) {
			result.add(list);
			return;
		}
		if (root.left != null) {
			pathSum(root.left, target, new ArrayList<>(list), currentSum);
		}
		if (root.right != null) {
			pathSum(root.right, target, new ArrayList<>(list), currentSum);
		}
	}
}