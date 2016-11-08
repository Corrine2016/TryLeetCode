import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of integers that might contain duplicates, nums, 
return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]*/
public class _90_SubsetsII {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		System.out.println(subsetsWithDup(nums));

	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length + 1; i++) {
			List<List<Integer>> subRes = new ArrayList<>();

			backtrack(subRes, new ArrayList<Integer>(), nums, i, new boolean[nums.length]);
			res.addAll(subRes);
		}
		return res;

	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int size,
			boolean[] used) {
		if (tempList.size() == size) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
					continue;
				if (tempList.size() > 0 && tempList.get(tempList.size() - 1) > nums[i])
					continue;
				used[i] = true;
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, size, used);
				used[i] = false;
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
