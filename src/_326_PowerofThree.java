/*Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?*/
public class _326_PowerofThree {
	// public boolean isPowerOfThree(int n) {
	// if (n <= 0)
	// return false;
	// while (n > 1) {
	// if (n % 3 != 0)
	// return false;
	// n = n / 3;
	// }
	// return true;
	// }

	public static boolean isPowerOfThree(int n) {
		return n > 0 && 1162261467 % n == 0;
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfThree(1));
	}
}
