import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*Given a binary search tree (BST) with duplicates, find all the mode(s) 
 (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],
 1
 \
 2
 /
 2
 return [2].

 Note: If a tree has more than one mode, you can return them in any order.

 Follow up: Could you do that without using any extra space? 
 (Assume that the implicit stack space incurred due to recursion does not count).*/

/**
 * @author Corrine
 *
 */
public class _501_FindModeinBinarySearchTree {

	public int[] findMode(TreeNode root) {
		if (root == null)
			return new int[0];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		traverseTree(map, root);
		List<Integer> list = new ArrayList<Integer>();
		int max = Collections.max(map.values());
		for (Integer key : map.keySet()) {
			if (map.get(key) == max)
				list.add(key);
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}

		return res;

	}

	private void traverseTree(HashMap<Integer, Integer> map, TreeNode root) {
		if (root == null)
			return;
		if (!map.keySet().contains(root.val))
			map.put(root.val, 1);
		else {
			map.put(root.val, map.get(root.val) + 1);
		}
		traverseTree(map, root.left);
		traverseTree(map, root.right);

	}
}
