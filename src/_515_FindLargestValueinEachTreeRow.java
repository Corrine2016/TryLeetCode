import java.util.ArrayList;
import java.util.List;

/*You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]*/
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

/**
 * @author corrine
 *
 */
public class _515_FindLargestValueinEachTreeRow {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		ArrayList<TreeNode> list = new ArrayList<>();
		list.add(root);
		while (!list.isEmpty()) {
			ArrayList<TreeNode> temp = new ArrayList<>();
			int max = Integer.MIN_VALUE;
			for (TreeNode r : list) {
				if (r.val > max)
					max = r.val;
				if (r.left != null)
					temp.add(r.left);
				if (r.right != null)
					temp.add(r.right);
			}
			list.clear();
			list.addAll(temp);
			result.add(max);
		}
		return result;

	}

}
