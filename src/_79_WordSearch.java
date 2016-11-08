/*Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.*/
public class _79_WordSearch {
	public boolean exist(char[][] board, String word) {
		char[] wordArray = word.toCharArray();
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, dirs, i, j, wordArray, 0))
					return true;
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, int[][] dirs, int i, int j, char[] word, int start) {
		if (start == word.length)
			return true;
		if (i < 0 || j < 0 || i == board.length || j == board[0].length)
			return false;
		if (board[i][j] == '#' || board[i][j] != word[start])
			return false;

		boolean res = false;
		char c = board[i][j];
		board[i][j] = '#'; // use '#' to represent this cell is visited

		for (int[] dir : dirs) {
			int newRow = i + dir[0], newCol = j + dir[1];
			res |= dfs(board, dirs, newRow, newCol, word, start + 1);
			if (res)
				return true; // if successfully find the word, return
								// immediately
		}

		board[i][j] = c; // backtracking
		return false;
	}
}
