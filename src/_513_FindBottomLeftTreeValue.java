import java.util.ArrayList;

/*Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.*/

/**
 * @author corrine
 *
 */
public class _513_FindBottomLeftTreeValue {
	public int findBottomLeftValue(TreeNode root) {
		ArrayList<TreeNode> list = new ArrayList<>();
		int leftMost = root.val;
		list.add(root);

		while (!list.isEmpty()) {
			ArrayList<TreeNode> temp = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				TreeNode cur = list.get(i);
				if (cur.left != null)
					temp.add(cur.left);
				if (cur.right != null)
					temp.add(cur.right);
			}
			if (!temp.isEmpty())
				leftMost = temp.get(0).val;
			list.clear();
			list.addAll(temp);
			System.out.println(list);
		}
		return leftMost;

	}
}
