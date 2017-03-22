package array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

/**
 * @author Corrine
 *
 */
public class _18_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < nums.length - 3; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int[] num = new int[nums.length - i - 1];
				System.arraycopy(nums, i + 1, num, 0, nums.length - i - 1);
				// System.out.println(Arrays.toString(num));
				List<List<Integer>> lists = threeSum(num, target - nums[i]);
				// System.out.println(lists);
				for (List<Integer> list : lists) {
					// 抽象的List无add方法，需要转ArrayList
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.addAll(list);
					temp.add(nums[i]);
					res.add(temp);
				}

			}
		}
		return res;
	}

	public static List<List<Integer>> threeSum(int[] num, int target) {
		// Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int lo = i + 1, hi = num.length - 1, sum = target - num[i];
				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while (lo < hi && num[lo] == num[lo + 1])
							lo++;
						while (lo < hi && num[hi] == num[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (num[lo] + num[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return res;
	}
}
