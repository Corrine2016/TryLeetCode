package hashset;
import java.util.Arrays;

/*Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
*/
//answer
//https://discuss.leetcode.com/topic/6650/share-my-dp-solution
public class _85_MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[] left = new int[n];
		int[] right = new int[n];
		int[] height = new int[n];
		Arrays.fill(right, n);
		int max = 0;
		for (int i = 0; i < m; i++) {
			int curleft = 0;
			int curright = n;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					height[j] += 1;
				} else {
					height[j] = 0;
				}
			}
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					left[j] = Math.max(left[j], curleft);
				} else {
					left[j] = 0;
					curleft = j + 1;
				}
			}
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(right[j], curright);
				} else {
					right[j] = n;
					curright = j;
				}
			}
			for (int j = 0; j < n; j++) {
				max = Math.max(max, (right[j] - left[j]) * height[j]);
			}
		}
		return max;
	}
}
