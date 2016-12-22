/*Given an 2D board, count how many different battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:

You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
Follow up:
Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?*/
//answer
/*这种思路利用了船只能在水平方向或是垂直方向上延伸，因此船的最左边（水平方向）或是最上边（垂直方向）的元素就很特殊，因为它的左边（水平方向）或是上边（垂直方向）的元素会是’.’，而对于船中部的元素，它们的左边或是上边的元素肯定有一个会是’X’。 
利用这点，我们可以遍历矩阵每一个元素，当符合是船头元素时，就增加船的个数，否则继续遍历下一个元素，最后返回找到的船的个数即可。*/
public class _419_BattleshipsinaBoard {
	public int countBattleships(char[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X'))
					count++;
		return count;
	}
}
