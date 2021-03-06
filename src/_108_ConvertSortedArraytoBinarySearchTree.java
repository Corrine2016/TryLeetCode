//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
public class _108_ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);

	}

	public TreeNode helper(int[] nums, int start, int end) {
		if (start > end || nums.length == 0)
			return null;
		int mid = (end - start) / 2 + start;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, start, mid - 1);
		root.right = helper(nums, mid + 1, end);
		return root;
	}
}
