import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.*/

/**
 * @author corrine
 *
 */
public class _52_NQueensII {

	private Set<Integer> col = new HashSet<Integer>();
	private Set<Integer> diag1 = new HashSet<Integer>();
	private Set<Integer> diag2 = new HashSet<Integer>();

	public int totalNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		dfs(res, new ArrayList<String>(), 0, n);
		return res.size();
	}

	private void dfs(List<List<String>> res, List<String> list, int row, int n) {
		if (row == n) {
			res.add(new ArrayList<String>(list));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i))
				continue;

			char[] charArray = new char[n];
			Arrays.fill(charArray, '.');
			charArray[i] = 'Q';
			String rowString = new String(charArray);

			list.add(rowString);
			col.add(i);
			diag1.add(row + i);
			diag2.add(row - i);

			dfs(res, list, row + 1, n);

			list.remove(list.size() - 1);
			col.remove(i);
			diag1.remove(row + i);
			diag2.remove(row - i);
		}
	}
}
