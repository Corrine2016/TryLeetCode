/*You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?*/
public class _48_RotateImage {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2 }, { 3, 4 } };
		rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {

				System.out.print(matrix[i][j] + " ");

			}
			System.out.println();
		}

	}

	public static void rotate(int[][] matrix) {
		int rows = matrix.length;

		int[][] temp = new int[rows][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				temp[j][rows - i - 1] = matrix[i][j];
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				matrix[i][j] = temp[i][j];
			}
		}
	}
}
