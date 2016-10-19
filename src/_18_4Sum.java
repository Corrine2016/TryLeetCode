import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]*/
public class _18_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {

		ArrayList<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4)
			return res;
		Arrays.sort(nums);

		if (nums[0] * 4 > target || nums[nums.length - 1] * 4 < target) {
			return res;
		}

		// following is four sum:
		for (int i = 0; i < nums.length - 3; i++) {
			if (nums[i] + nums[nums.length - 1] * 3 < target) // nums[i] is too
																// small
				continue;
			if (nums[i] * 4 > target) { // nums[i] is too big
				break;
			}

			if (i > 0 && nums[i] == nums[i - 1]) // jump duplicate
				continue;

			// following is three sum:
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (nums[i] + nums[j] + nums[nums.length - 1] * 2 < target) // nums[j]
																			// is
																			// too
																			// small
					continue;
				if (nums[i] + nums[j] * 3 > target) { // nums[j] is too big
					break;
				}

				if (j > i + 1 && nums[j] == nums[j - 1]) // jump duplicate
					continue;

				// following is two sum:
				int low = j + 1, high = nums.length - 1;
				while (low < high) {
					int sum = nums[i] + nums[j] + nums[low] + nums[high];
					if (sum == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
						while (low < high && nums[low] == nums[low + 1]) // jump
																			// duplicate
							low++;
						while (low < high && nums[high] == nums[high - 1]) // jump
																			// duplicate
							high--;
						low++;
						high--;
					} else if (sum < target)
						low++;
					else
						high--;
				}
			}
		}
		return res;
	}
}
