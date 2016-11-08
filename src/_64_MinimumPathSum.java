//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom
//right which minimizes the sum of all numbers along its path.
//
//Note: You can only move either down or right at any point in time.

//https://discuss.leetcode.com/topic/3184/ac-java-dp-solution-v-s-tle-dijstra-solution
public class _64_MinimumPathSum {
	private int getDist(int[][] dist, int x, int y) {
		if (x < 0 || y < 0) {
			return Integer.MAX_VALUE;
		}

		return dist[x][y];
	}

	private int min(int i1, int i2) {
		return i1 < i2 ? i1 : i2;
	}

	public int minPathSum(int[][] grid) {

		if (grid == null || grid.length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;

		int[][] dist = new int[m][n];

		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {

				if (x == 0 && y == 0) {
					dist[0][0] = grid[0][0];
				} else {
					dist[x][y] = min(getDist(dist, x - 1, y), getDist(dist, x, y - 1)) + grid[x][y];
				}
			}
		}

		return dist[m - 1][n - 1];

	}
}
