import java.util.Arrays;

/*Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant extra space complexity?*/

/**
 * @author corrine
 *
 */
// 推荐方法
// https://discuss.leetcode.com/topic/24535/4-line-simple-java-bit-manipulate-solution-with-explaination/2
public class _268_MissingNumber {
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);

		int start = nums[0];
		if (start != 0)
			return 0;
		int i = 0;
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i + start)
				break;
		}
		return i + start;

	}
}
