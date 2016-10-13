/*Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?*/
public class _342_PowerofFour {
	public boolean isPowerOfFour(int num) {
		int x = (int) Math.sqrt(num);
		// 1073741824 is 4^15, 4^16 is bigger than int
		return (num > 0 && 1073741824 % num == 0 && x * x == num);
	}

	// >>> a=2**31-1
	// >>> print a
	// 2147483647
	// >>> import math
	// >>> b=math.log(a,4)
	// >>> print b
	// 15.4999999997
	// >>> print math.pow(4,15)
	// 1073741824.0
	// >>>
}
