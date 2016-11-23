/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.

You may assume no duplicate exists in the array.*/

/**
 * @author corrine
 *
 */
public class _153_FindMinimuminRotatedSortedArray {
	public static void main(String[] args) {
		int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(findMin(nums));
	}

	public static int findMin(int[] nums) {

		int i = 0;
		while (i <= nums.length - 2 && nums[i] <= nums[i + 1])
			i++;
		return nums[(i + 1) % nums.length];

	}
}
