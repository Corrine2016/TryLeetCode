import java.util.Arrays;

/*Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.*/
public class _81_SearchinRotatedSortedArrayII {

	public static void main(String[] args) {
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 8));

	}

	public static boolean search(int[] nums, int target) {
		int rotate = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1])
				rotate = i;
		}
		Arrays.sort(nums);
		int temp = Arrays.binarySearch(nums, target);
		boolean res;
		if (temp < 0)
			res = false;
		else {
			res = true;
		}
		return res;

	}
}
