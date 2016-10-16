/*Given an array of integers A and let n to be its length.

Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

Calculate the maximum value of F(0), F(1), ..., F(n-1).

Note:
n is guaranteed to be less than 105.
Example:

A = [4, 3, 2, 6]

F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.*/

//F0 = 0 + 1a1 + 2a2 + 3a3
//
//F1 = F0 + a0 + a1 + a2 - 3a3 = F0 + a0 + a1 + a2 + a3 - 4a3
//
//F2 = F1 + a3 + a0 + a1 - 3a2 = F1 + a0 + a1 + a2 + a3 - 4a2
//
//F3 = F2 + a2 + a3 + a0 - 3a1 = F2 + a0 + a1 + a2 + a3 - 4a1
public class _396_RotateFunction {
	public static void main(String[] args) {
		int[] A = { 4, 3, 2, 6 };
		System.out.println(maxRotateFunction(A));
	}

	public static int maxRotateFunction(int[] A) {

		int F = 0;
		int max = 0;
		int sum = 0;
		int n = A.length;
		if (n <= 1)
			return 0;
		for (int i = 0; i < n; i++) {
			F += i * A[i];
			sum += A[i];
		}
		max = F;
		for (int k = 1; k < n; k++) {
			F += sum;
			F -= n * A[n - k];
			if (F > max)
				max = F;
		}
		return max;
	}
}
