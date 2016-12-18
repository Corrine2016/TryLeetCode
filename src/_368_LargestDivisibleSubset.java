import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a set of distinct positive integers, find the largest subset such 
that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)
Example 2:

nums: [1,2,4,8]

Result: [1,2,4,8]*/
//	answer
public class _368_LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> ans = new ArrayList<Integer>();
		if (nums.length == 0)
			return ans;
		Arrays.sort(nums);
		int n = nums.length;
		int[] dp = new int[n], index = new int[n];
		Arrays.fill(dp, 1);
		Arrays.fill(index, -1);
		int max_index = 0, max_dp = 1;
		for (int i = 0; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					index[i] = j;
				}
			}
			if (max_dp < dp[i]) {
				max_dp = dp[i];
				max_index = i;
			}
		}
		for (int i = max_index; i != -1; i = index[i])
			ans.add(nums[i]);
		return ans;
	}
}