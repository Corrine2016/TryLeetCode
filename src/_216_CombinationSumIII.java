import java.util.ArrayList;
import java.util.List;

/*Find all possible combinations of k numbers that add up to a number n,
given that only numbers from 1 to 9 can be used and each combination should be a 
unique set of numbers.
Example 1:

Input: k = 3, n = 7
Output:
[[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output:
[[1,2,6], [1,3,5], [2,3,4]]*/

/**
 * @author corrine
 *
 */
public class _216_CombinationSumIII {
	public static void main(String[] args) {
		System.out.println(combinationSum3(2, 6));
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(res, k, n, new ArrayList<Integer>());
		return res;
	}

	private static void helper(List<List<Integer>> res, int k, int n, ArrayList<Integer> temp) {
		int count = 0;
		for (int i = 0; i < temp.size(); i++) {
			count = count + temp.get(i);
		}

		if (count == n && temp.size() == k) {
			res.add(new ArrayList<>(temp));
		} else {

			for (int i = 1; i < 10 && temp.size() < k; i++) {
				if (temp.size() == 0 || (temp.size() > 0 && i > temp.get(temp.size() - 1))) {
					temp.add(i);
					helper(res, k, n, temp);
					temp.remove(temp.size() - 1);
				}

			}
		}

	}
}
