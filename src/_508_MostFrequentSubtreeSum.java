import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.*/
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

/**
 * @author corrine
 *
 */
public class _508_MostFrequentSubtreeSum {
	public int[] findFrequentTreeSum(TreeNode root) {
		if (root == null)
			return new int[0];
		ArrayList<Integer> list = new ArrayList<>();
		countSum(list, root);

		System.out.println(list);
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : list) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		list.clear();
		for (Integer key : map.keySet()) {
			list.add(map.get(key));
		}
		int max = Collections.max(list);
		list.clear();
		for (Integer key : map.keySet()) {
			if (map.get(key) == max)
				list.add(key);
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	private int countSum(ArrayList<Integer> list, TreeNode root) {
		if (root == null)
			return 0;
		int sum = root.val + countSum(list, root.right) + countSum(list, root.left);

		list.add(sum);

		return sum;

	}

}
