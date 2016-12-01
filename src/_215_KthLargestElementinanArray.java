import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

*/

/**
 * @author corrine
 *
 */
public class _215_KthLargestElementinanArray {
	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		System.out.println(findKthLargest(nums, k));
	}

	public static int findKthLargest(int[] nums, int k) {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		int res = 0;
		for (int i = 0; i < k; i++) {
			res = Collections.max(list);
			list.remove(Collections.max(list));
		}
		return res;
	}
}
