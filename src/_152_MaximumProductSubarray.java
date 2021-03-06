/*Find the contiguous subarray within an array (containing at least one number)
which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.*/
//answer

/*f[i] means maximum product that can be achieved ending with i

g[i] means minimum product that can be achieved ending with i*/
public class _152_MaximumProductSubarray {
	public int maxProduct(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int[] f = new int[A.length];
		int[] g = new int[A.length];
		f[0] = A[0];
		g[0] = A[0];
		int res = A[0];
		for (int i = 1; i < A.length; i++) {
			f[i] = Math.max(Math.max(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
			g[i] = Math.min(Math.min(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
			res = Math.max(res, f[i]);
		}
		return res;
	}
}
