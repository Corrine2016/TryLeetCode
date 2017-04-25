package hashset;
/*Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


There are just 3 rules to Sudoku.
Each row must have the numbers 1-9 occuring just once.
Each column must have the numbers 1-9 occuring just once.
And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.

A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.*/
public class _36_ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
		boolean res = false;
		if (board == null || board.length != 9 || board[0].length != 9)
			return res;
		boolean[][] row = new boolean[9][9]; // keep existed values in each row
		boolean[][] col = new boolean[9][9]; // keep existed values in each
												// column
		boolean[][] block = new boolean[9][9]; // keep existed values in each 3
												// * 3 subblock
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (row[i][board[i][j] - '1'] || col[j][board[i][j] - '1']
							|| block[(i / 3) * 3 + j / 3][board[i][j] - '1']) {
						// Once the value existed in the row or column or
						// subblock, return false
						return res;
					} else { // otherwise, record this value in the three
								// boolean array.
						row[i][board[i][j] - '1'] = true;
						col[j][board[i][j] - '1'] = true;
						block[(i / 3) * 3 + j / 3][board[i][j] - '1'] = true;
					}
				}
			}
		}

		res = true;
		return res;

	}

}
