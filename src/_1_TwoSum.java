/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/
import java.util.HashMap;

public class _1_TwoSum {
	public static void test() {
		int[] nums = { 2, 5, 7, 9 };
		int target = 7;
		Main.showArray(twoSum(nums, target));

	}

	public static int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int remain = target - nums[i];
			if (hashMap.containsKey(remain)) {

				return new int[] { hashMap.get(remain), i };
			}
			hashMap.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");

	}

}
