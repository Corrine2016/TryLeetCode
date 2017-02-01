/*Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

Hint:

Beware of overflow.*/
//answer hard 
//https://discuss.leetcode.com/topic/18972/ac-short-java-solution/2
//http://blog.csdn.net/xudli/article/details/46798619
public class _233_NumberofDigitOne {
	public int countDigitOne(int n) {
		int count = 0;

		for (long k = 1; k <= n; k *= 10) {
			long r = n / k, m = n % k;
			// sum up the count of ones on every place k
			count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
		}

		return count;
	}
}