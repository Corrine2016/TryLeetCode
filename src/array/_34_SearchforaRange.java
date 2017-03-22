package array;
import java.util.Arrays;

/*Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].*/
public class _34_SearchforaRange {
	public static void main(String[] args) {
		int[] a = { 5, 7, 7, 8, 8, 10 };
		System.out.println(Arrays.toString(searchRange(a, 8)));
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };
		int position = binarySearch(nums, target);
		System.out.println(position);
		int i = position, j = position;
		if (position != -1) {

			while (i > -1 && nums[i] == target)
				i--;

			while (j < nums.length && nums[j] == target)
				j++;

			result[0] = i + 1;
			result[1] = j - 1;
		}
		return result;

	}

	private static int binarySearch(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (nums[mid] < target) {
				low = mid + 1;
			} else if (nums[mid] > target)
				high = mid - 1;
			else {
				return mid;
			}
		}
		return -1;
	}
}
