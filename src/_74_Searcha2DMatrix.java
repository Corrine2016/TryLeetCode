import java.util.Arrays;

/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.*/
public class _74_Searcha2DMatrix {
	public static void main(String[] args) {
		// int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34,
		// 50 } };
		int[][] matrix = { { 1 } };
		System.out.println(searchMatrix(matrix, 0));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int[] nums = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			nums[i] = matrix[i][0];
		}
		int temp = binarySearch(nums, target);
		System.out.println(temp);
		if (temp > 0)
			return true;
		else if (temp == 0)
			return false;
		else {
			int row = -temp - 1;
			int[] nums2 = new int[matrix[0].length];
			for (int i = 0; i < matrix[0].length; i++) {
				nums2[i] = matrix[row][i];
			}
			System.out.println(Arrays.toString(nums2));
			int res = binarySearch(nums2, target);
			if (res > 0)
				return true;

			else {
				return false;
			}

		}

	}

	private static int binarySearch(int[] nums, int target) {
		int low = 0, high = nums.length - 1, mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (nums[mid] < target)
				low = mid + 1;
			else if (nums[mid] > target)
				high = mid - 1;
			else {
				return mid + 1;
			}
		}
		return -low;

	}
}
