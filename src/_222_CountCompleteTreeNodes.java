/*Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.*/
//answer
//https://discuss.leetcode.com/topic/54636/java-use-binary-search-84ms-beats-78-with-explanation
public class _222_CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int h = getHeight(root);
		if (h == 1) {
			return 1;
		}
		int hRight = getHeight(root.right);
		if (hRight == h - 1) {
			return (1 << h - 1) + countNodes(root.right);
		} else {
			return (1 << h - 2) + countNodes(root.left);
		}
	}

	private int getHeight(TreeNode root) {
		int h = 0;
		while (root != null) {
			h++;
			root = root.left;
		}
		return h;
	}
}
