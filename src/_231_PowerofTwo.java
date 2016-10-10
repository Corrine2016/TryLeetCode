//Given an integer, write a function to determine if it is a power of two.
public class _231_PowerofTwo {

	public boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		while (n != 0) {
			if (n % 2 != 0 && n != 1)
				return false;
			n = n / 2;
		}
		return true;
	}
}
