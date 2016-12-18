import java.util.Arrays;

/*Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?*/
//answer
//https://discuss.leetcode.com/topic/66299/my-java-solution-it-is-fast-and-easy-to-understand
public class _324_WiggleSortII {
	public static void wiggleSort(int[] nums) {

		// [1,1,1,4,5,6]
		Arrays.sort(nums);

		int len = nums.length;
		// the big num index need to move
		// when the len is odd the index should be add 1;
		// make sure that a1 >= a2
		int index = (int) Math.round(new Double(len) / 2);

		int[] a1 = new int[index];
		// [1,1,1]
		int k = 0;
		for (int i = index - 1; i >= 0; i--) {
			a1[k++] = nums[i];
		}
		int[] a2 = new int[len - index];
		// [6,5,4]
		k = 0;
		for (int i = len - 1; i >= index; i--) {
			a2[k++] = nums[i];
		}

		// at last fill the nums array
		k = 0;
		for (int i = 0; i < index && k < len; i++, k += 2) {
			nums[k] = a1[i];
			if (k < len - 1) {
				nums[k + 1] = a2[i];
			}
		}

	}
}
