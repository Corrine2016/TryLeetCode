/*Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]*/
public class _59_SpiralMatrixII {
	public static void main(String[] args) {
		int n = 0;
		int[][] matrix = generateMatrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		boolean[][] isAdd = new boolean[n][n];
		int count = 1;
		for (int i = 0; i <= (n - 1) / 2; i++) {
			count = addRow(matrix, isAdd, i, count);
			count = addCol(matrix, isAdd, n - 1 - i, count);
			count = addReverseRow(matrix, isAdd, n - 1 - i, count);
			count = addReverseCol(matrix, isAdd, i, count);
		}
		return matrix;
	}

	private static int addRow(int[][] matrix, boolean[][] isAdd, int i, int count) {

		int n = isAdd.length;
		for (int j = 0; j < n; j++) {
			if (!isAdd[i][j]) {
				matrix[i][j] = count;
				count++;
				isAdd[i][j] = true;
			}
		}
		return count;

	}

	private static int addCol(int[][] matrix, boolean[][] isAdd, int j, int count) {
		int n = isAdd.length;
		for (int i = 0; i < n; i++) {
			if (!isAdd[i][j]) {
				matrix[i][j] = count;
				count++;
				isAdd[i][j] = true;
			}
		}
		return count;
	}

	private static int addReverseRow(int[][] matrix, boolean[][] isAdd, int i, int count) {
		int n = isAdd.length;
		for (int j = n - 1; j > -1; j--) {
			if (!isAdd[i][j]) {
				matrix[i][j] = count;
				count++;
				isAdd[i][j] = true;
			}
		}
		return count;
	}

	private static int addReverseCol(int[][] matrix, boolean[][] isAdd, int j, int count) {
		int n = isAdd.length;
		for (int i = n - 1; i > -1; i--) {
			if (!isAdd[i][j]) {
				matrix[i][j] = count;
				count++;
				isAdd[i][j] = true;
			}
		}
		return count;
	}
}
