
/*Write a program to find the nth super ugly number.

 Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

 Note:
 (1) 1 is a super ugly number for any given primes.
 (2) The given numbers in primes are in ascending order.
 (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.*/
//http://www.cnblogs.com/yrbbest/p/5062988.html
//answer
public class _313_SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		if (n < 1) {
			return 0;
		}
		int len = primes.length;
		int[] index = new int[len];
		int[] dp = new int[n];
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < len; j++) { // try update with all primes
				min = Math.min(dp[index[j]] * primes[j], min);
			}
			dp[i] = min; // find dp[i]
			for (int j = 0; j < len; j++) { // if prices[j] is used, increase
											// the index
				if (dp[i] % primes[j] == 0) {
					index[j]++;
				}
			}
		}
		return dp[n - 1];
	}
}
