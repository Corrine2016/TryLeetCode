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
public class _39_CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList,
			int[] cand, int remain, int start) {
		if (remain < 0)
			return;
		/** no solution */
		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < cand.length; i++) {
				tempList.add(cand[i]);
				backtrack(list, tempList, cand, remain - cand[i], i);
				tempList.remove(tempList.size() - 1);
			}
		}

	}
}
