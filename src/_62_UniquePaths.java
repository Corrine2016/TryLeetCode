import java.util.Arrays;

/*A robot is located at the top-left corner of a m x n grid (marked 'Start'
		in the diagram below).

The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?*/
public class _62_UniquePaths {
	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 7));
	}

	public static int uniquePaths(int m, int n) {
		int[] table = new int[n];
		Arrays.fill(table, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				table[j] = table[j] + table[j - 1];
			}
		}
		return table[n - 1];

	}
}
