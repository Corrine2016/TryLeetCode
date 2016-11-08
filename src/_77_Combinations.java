import java.util.ArrayList;
import java.util.List;

/*Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]*/
public class _77_Combinations {
	public static void main(String[] args) {
		System.out.println(combine(4, 2));
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		combination(res, new ArrayList<Integer>(), n, k);
		return res;

	}

	public static void combination(List<List<Integer>> res, List<Integer> temp, int n, int k) {

		if (temp.size() == k) {
			res.add(new ArrayList<>(temp));

		} else {
			for (int i = 1; i <= n; i++) {
				if (temp.size() > 0 && i < temp.get(temp.size() - 1))
					continue;
				if (!temp.contains(i)) {
					temp.add(i);
					combination(res, temp, n, k);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}

}
