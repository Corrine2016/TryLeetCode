import java.util.Arrays;

/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, 
target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/
public class _16_3SumClosest {
	public static void main(String[] args) {

	}

	public int threeSumClosest(int[] nums, int target) {
		int sumres = 0, mindiff = Integer.MAX_VALUE;

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1, end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				int diff = Math.abs(sum - target);
				if (diff < mindiff) {
					mindiff = diff;
					sumres = sum;
				}
				if (sum < target) {
					start++;
				} else if (sum > target) {
					end--;
				} else
					return sum;
			}
		}
		return sumres;
	}
}
