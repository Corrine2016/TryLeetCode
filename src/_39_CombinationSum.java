import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C 
 * where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7, 
 A solution set is: 
 [
 [7],
 [2, 2, 3]
 ]*/

/**
 * @author Corrine
 *
 */
public class _39_CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		backtrack(res, new ArrayList<Integer>(), candidates, target, target);
		return res;

	}

	private void backtrack(List<List<Integer>> res, ArrayList<Integer> temp,
			int[] candidates, int target, int remain) {
		if (remain < 0)
			return;
		else if (remain == 0)
			res.add(new ArrayList<Integer>(temp));
		else {
			for (int i = 0; i < candidates.length; i++) {
				if (temp.size() == 0
						|| candidates[i] >= temp.get(temp.size() - 1)) {
					temp.add(candidates[i]);
					backtrack(res, temp, candidates, target, remain
							- candidates[i]);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}
}
