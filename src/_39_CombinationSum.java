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
	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		System.out.println(combinationSum(candidates, target));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		getResult(result, new ArrayList<Integer>(), candidates, target, 0);

		return result;
	}

	private static void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target,
			int start) {
		if (target > 0) {
			for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
				cur.add(candidates[i]);
				getResult(result, cur, candidates, target - candidates[i], i);
				cur.remove(cur.size() - 1);
			} // for
		} // if
		else if (target == 0) {
			result.add(new ArrayList<Integer>(cur));
		} // else if
	}
}