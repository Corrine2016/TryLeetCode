import java.util.Arrays;

/*Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.*/

/**
 * @author corrine
 *
 */
public class _304_RangeSumQuery2D {
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		NumMatrix numMatrix = new NumMatrix(matrix);
		numMatrix.show();
		System.out.println(numMatrix.sumRegion(1, 2, 2, 4));

	}

}

class NumMatrix {
	private int[][] sumMatrix;
	private int sum;

	public void show() {
		for (int i = 0; i < sumMatrix.length; i++) {
			System.out.println(Arrays.toString(sumMatrix[i]));
		}
	}

	public NumMatrix(int[][] matrix) {

		int m = matrix.length;
		int n = 0;
		if (m != 0)
			n = matrix[0].length;
		sumMatrix = new int[m][n + 1];
		for (int i = 0; i < m; i++) {
			sumMatrix[i][0] = 0;
			for (int j = 1; j < n + 1; j++) {
				sumMatrix[i][j] = sumMatrix[i][j - 1] + matrix[i][j - 1];
			}
		}

	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		sum = 0;
		for (int i = row1; i <= row2; i++) {
			sum += sumMatrix[i][col2 + 1] - sumMatrix[i][col1];
		}
		return sum;

	}
}

// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
