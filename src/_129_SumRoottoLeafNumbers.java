import java.util.ArrayList;
import java.util.List;

/*Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
*/

public class _129_SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		List<String> list = binaryTreePaths(root);
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum = sum + Integer.parseInt(list.get(i));
		}
		return sum;
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> answer = new ArrayList<String>();
		if (root != null)
			searchBT(root, "", answer);
		return answer;
	}

	private void searchBT(TreeNode root, String path, List<String> answer) {
		if (root.left == null && root.right == null)
			answer.add(path + root.val);
		if (root.left != null)
			searchBT(root.left, path + root.val, answer);
		if (root.right != null)
			searchBT(root.right, path + root.val, answer);
	}
}
