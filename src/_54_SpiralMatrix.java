import java.util.ArrayList;
import java.util.List;

/*Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix 
		in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].*/
public class _54_SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 2, 5, 8 }, { 4, 0, -1 } };
		System.out.println(spiralOrder(matrix));
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		int m = matrix.length;
		if (m == 0)
			return list;
		int n = matrix[0].length;
		boolean[][] isAdd = new boolean[m][n];
		for (int i = 0; i <= (Math.min(m, n) - 1) / 2; i++) {
			addRow(list, matrix, isAdd, i);
			addCol(list, matrix, isAdd, n - 1 - i);
			addReverseRow(list, matrix, isAdd, m - 1 - i);
			addReverseCol(list, matrix, isAdd, i);
		}
		return list;
	}

	private static void addRow(List<Integer> list, int[][] matrix, boolean[][] isAdd, int i) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int j = 0; j < n; j++) {
			if (!isAdd[i][j]) {
				list.add(matrix[i][j]);
				isAdd[i][j] = true;
			}
		}

	}

	private static void addCol(List<Integer> list, int[][] matrix, boolean[][] isAdd, int j) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			if (!isAdd[i][j]) {
				list.add(matrix[i][j]);
				isAdd[i][j] = true;
			}
		}
	}

	private static void addReverseRow(List<Integer> list, int[][] matrix, boolean[][] isAdd, int i) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int j = n - 1; j > -1; j--) {
			if (!isAdd[i][j]) {
				list.add(matrix[i][j]);
				isAdd[i][j] = true;
			}
		}

	}

	private static void addReverseCol(List<Integer> list, int[][] matrix, boolean[][] isAdd, int j) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = m - 1; i > -1; i--) {
			if (!isAdd[i][j]) {
				list.add(matrix[i][j]);
				isAdd[i][j] = true;
			}
		}
	}

}
