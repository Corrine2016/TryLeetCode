import java.util.ArrayList;
import java.util.List;

/*Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/
public class _78_Subsets {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(subsets(nums));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		for (int k = 0; k <= nums.length; k++) {
			List<List<Integer>> res = new ArrayList<>();
			combination(res, new ArrayList<Integer>(), nums, k);
			list.addAll(res);
		}
		return list;
	}

	public static void combination(List<List<Integer>> res, List<Integer> temp, int[] nums, int k) {

		if (temp.size() == k) {
			res.add(new ArrayList<>(temp));

		} else {
			for (int i = 0; i < nums.length; i++) {
				if (temp.size() > 0 && nums[i] <= temp.get(temp.size() - 1))
					continue;
				if (!temp.contains(nums[i])) {
					temp.add(nums[i]);
					combination(res, temp, nums, k);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}

}
