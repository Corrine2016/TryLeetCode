import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/*Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.
*/
public class _80_RemoveDuplicatesfromSortedArrayII {
	public static void main(String[] args) {
		int[] nums = { -3, -1, 0, 0, 0, 3, 3 };
		System.out.println(removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}

	public static int removeDuplicates(int[] nums) {
		int[] res = new int[nums.length];
		HashMap<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], 1);
			else
				map.put(nums[i], map.get(nums[i]) + 1);
		}

		int count = 0;
		Iterator iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			int temp = (Integer) iterator.next();

			if (map.get(temp) >= 2) {

				res[count] = temp;
				res[count + 1] = temp;
				count = count + 2;

			}

			else {
				res[count] = temp;
				count++;
			}
		}
		System.out.println(Arrays.toString(res));
		System.arraycopy(res, 0, nums, 0, count);
		return count;
	}
}
