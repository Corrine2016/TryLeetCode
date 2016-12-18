import java.util.Collections;
import java.util.PriorityQueue;

/*Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
*/

public class _378_KthSmallestElementinaSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue(k, Collections.reverseOrder());

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (pq.size() < k)
					pq.add(matrix[i][j]);
				else {
					int temp = pq.peek();
					if (temp > matrix[i][j]) {
						pq.poll();
						pq.offer(matrix[i][j]);
					}
				}
			}
		}
		return pq.poll();
	}
}
