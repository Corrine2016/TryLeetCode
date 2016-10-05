//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//Do not allocate extra space for another array, you must do this in place with constant memory.
//For example,
//Given input array nums = [1,1,2],
//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

public class _26_RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		System.out.println(removeDuplicates(nums));

	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
}
