package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1_a {
	public static void main(String[] args) {
		_1_a obj = new _1_a();
		int[] nums = new int[] { 1, 1, 2, 5, 6, 7, 10 };
		int val = 8;
		System.out.println(obj.combinationSum2(nums, val));
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		backtrack(res, new ArrayList<Integer>(), candidates, target, target, 0);
		return res;

	}

	private void backtrack(List<List<Integer>> res, ArrayList<Integer> temp,
			int[] candidates, int target, int remain, int positon) {
		if (remain < 0)
			return;
		else if (remain == 0)
			res.add(new ArrayList<Integer>(temp));
		else {
			for (int i = positon; i < candidates.length; i++) {
				if (i > positon && candidates[i] == candidates[i - 1]) {
					continue;
				}
				temp.add(candidates[i]);
				backtrack(res, temp, candidates, target,
						remain - candidates[i], i + 1);
				temp.remove(temp.size() - 1);

			}

		}
	}
}
