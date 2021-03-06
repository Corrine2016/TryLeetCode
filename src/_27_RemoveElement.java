/*Given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.*/

/**
 * @author Corrine
 *
 */
public class _27_RemoveElement {
	public static void main(String[] args) {
		int[] nums = { 3, 2, 2, 3, 1, 3 };
		int val = 3;
		System.out.println(removeElement(nums, val));

	}

	public static int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}

		}
		return i;

	}

}
