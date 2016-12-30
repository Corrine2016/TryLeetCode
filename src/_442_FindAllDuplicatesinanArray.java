import java.util.ArrayList;
import java.util.List;

/*Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]*/

/**
 * @author corrine
 *
 */
public class _442_FindAllDuplicatesinanArray {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		boolean[] location = new boolean[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			int temp = nums[i];
			if (location[temp] == false) {
				location[temp] = true;
			} else
				res.add(temp);

		}
		return res;
	}
}
