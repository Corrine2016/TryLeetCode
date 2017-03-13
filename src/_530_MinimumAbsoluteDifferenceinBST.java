import java.util.LinkedList;
import java.util.TreeSet;

/*Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

 Example:

 Input:

 1
 \
 3
 /
 2

 Output:
 1

 Explanation:
 The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 Note: There are at least two nodes in this BST.*/

/**
 * @author Corrine
 *
 */
public class _530_MinimumAbsoluteDifferenceinBST {
	public int getMinimumDifference(TreeNode root) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		putSet(set, root);
		LinkedList<Integer> list = new LinkedList<Integer>(set);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < set.size(); i++) {
			min = Math.min(min, list.get(i) - list.get(i - 1));
		}
		return min;

	}

	private void putSet(TreeSet<Integer> set, TreeNode root) {
		if (root == null)
			return;
		set.add(root.val);
		putSet(set, root.left);
		putSet(set, root.right);

	}
}
