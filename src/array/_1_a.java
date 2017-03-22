package array;

public class _1_a {
	public static void main(String[] args) {
		_1_a obj = new _1_a();
		int[] nums = new int[] { 2, 3, 1, 1, 4 };
		int val = 8;
		// System.out.println(obj.(nums));
	}

	public int maxSubArray(int[] A) {
		int[] dp = new int[A.length];
		dp[0] = A[0];
		int max = dp[0];
		for (int i = 1; i < A.length; i++) {
			dp[i] = Math.max(dp[0], 0) + A[i];
			max = Math.max(max, dp[i]);

		}
		return max;
	}

}
