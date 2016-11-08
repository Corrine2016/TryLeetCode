import java.util.Arrays;

/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index,
		otherwise return -1.

You may assume no duplicate exists in the array.*/
public class _33_SearchinRotatedSortedArray {
	public static void main(String[] args) {
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 8));

	}

	public static int search(int[] nums, int target) {
		int rotate = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1])
				rotate = i;
		}
		Arrays.sort(nums);
		int temp = Arrays.binarySearch(nums, target);
		int res;
		if (temp < 0)
			res = -1;
		else {
			res = (temp + rotate) % nums.length;
		}
		return res;

	}

}
