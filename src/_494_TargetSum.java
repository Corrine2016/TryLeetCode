/*You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
Subscribe to see which companies asked this question.*/

/**
 * @author Corrine
 *
 */
public class _494_TargetSum {
	public int findTargetSumWays(int[] nums, int S) {
		if (nums.length == 1) {
			if (nums[0] == S && S == 0)
				return 2;
			if (nums[0] == S || nums[0] == -S && S != 0)
				return 1;
			else {
				return 0;
			}
		}
		int[] nums2 = new int[nums.length - 1];
		System.arraycopy(nums, 1, nums2, 0, nums.length - 1);
		int res = findTargetSumWays(nums2, S - nums[0])
				+ findTargetSumWays(nums2, S + nums[0]);
		return res;

	}
}
