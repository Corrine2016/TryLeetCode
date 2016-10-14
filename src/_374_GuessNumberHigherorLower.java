/*We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.*/

/*
 * The guess API is defined in the parent class GuessGame.
 * 
 * @param num, your guess
 * 
 * @return -1 if my number is lower, 1 if my number is higher, otherwise
 * return 0 int guess(int num);
 */
public class _374_GuessNumberHigherorLower {
	public static void main(String[] args) {
		System.out.println(guessNumber(10));

	}

	public static int guessNumber(int n) {
		int left = 1;
		int right = n;

		while (left <= right) {
			// i find that the begin+end will overflow and turn out to be a
			// negative number,
			// when input n is very big. So I change start = begin + (end -
			// begin)/2
			int mid = left + (right - left) / 2;
			int res = guess(mid);// API只调用一次，不然超时
			if (res == -1)
				right = mid - 1;

			else if (res == 1)
				left = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	private static int guess(int num) {
		int answer = 6;
		if (answer < num)
			return 1;
		else if (answer > num)
			return -1;
		else
			return 0;

	}

}
