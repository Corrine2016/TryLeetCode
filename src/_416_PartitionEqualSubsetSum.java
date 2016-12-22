/*Given a non-empty array containing only positive integers,
find if the array can be partitioned into two subsets such that the sum 
of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.*/
//answer
//https://discuss.leetcode.com/topic/62732/java-dynamic-programming-fastest/2
public class _416_PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0)
			return false;
		sum /= 2;

		boolean dp[][] = new boolean[nums.length + 1][sum + 1];

		for (int i = 0; i < nums.length + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = false;
			}
		}

		dp[0][0] = true;

		for (int i = 1; i < nums.length + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (j >= nums[i - 1])
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[nums.length][sum];
	}
}
