import java.util.ArrayList;

/*A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.


Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.*/

/**
 * @author corrine
 *
 */
public class _413_ArithmeticSlices {
	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 3, 4 };
		System.out.println(numberOfArithmeticSlices(A));
	}

	public static int numberOfArithmeticSlices(int[] A) {
		ArrayList<Integer> subSet = new ArrayList<>();
		if (A.length < 3)
			return 0;
		int start = 0;
		int end = 1;
		while (end < A.length - 1) {
			while (end < A.length - 1 && A[end + 1] - A[end] == A[end] - A[end - 1]) {
				end++;
			}
			System.out.println(end);

			if (end - start + 1 > 2) {
				subSet.add(end - start + 1);
				start = end + 1;
				end = start + 1;
			} else {
				start = start + 1;
				end = start + 1;

			}
		}
		System.out.println(subSet);
		int res = helper(subSet);
		return res;

	}

	private static int helper(ArrayList<Integer> subSet) {
		int sum = 0;
		for (int i = 0; i < subSet.size(); i++) {
			int temp = subSet.get(i);
			for (int j = 1; j < temp - 1; j++) {
				sum = sum + j;
			}
		}
		return sum;

	}

}
