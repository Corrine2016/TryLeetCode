import java.util.Arrays;

/*You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

 What is the maximum number of envelopes can you Russian doll? (put one inside other)

 Example:
 Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

 Subscribe to see which companies asked this question*/
//answer hard
public class _354_RussianDollEnvelopes {
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes.length == 0)
			return 0;
		Arrays.sort(envelopes, (int[] a, int[] b) -> (a[0] - b[0] == 0 ? a[1]
				- b[1] : a[0] - b[0]));
		int m = envelopes.length;
		// max end in index i
		int[] A = new int[m];
		int res = 1;
		Arrays.fill(A, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[i][0] > envelopes[j][0]
						&& envelopes[i][1] > envelopes[j][1]) {
					A[i] = Math.max(A[i], A[j] + 1);
				}
			}
			res = Math.max(res, A[i]);
		}
		return res;
	}
}
