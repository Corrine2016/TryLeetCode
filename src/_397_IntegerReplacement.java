/*Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1*/
//注意测试太长，改用long
/**
 * @author corrine
 *
 */
public class _397_IntegerReplacement {
	public int integerReplacement(int n) {
		return (int) longReplacement(n);
	}

	public long longReplacement(long n) {
		if (n < 3)
			return n - 1;
		if (n % 2 == 0)
			return longReplacement(n / 2) + 1;
		else
			return Math.min(longReplacement(n - 1), longReplacement(n + 1)) + 1;
	}
}
