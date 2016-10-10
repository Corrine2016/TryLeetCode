import java.util.HashMap;

/*
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j 
 * in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 */

public class _219_ContainsDuplicateII {
	public static void main(String[] args) {
		int[] nums = { -1 };
		int k = 1;
		System.out.println(containsNearbyDuplicate(nums, k));
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer value = map.put(nums[i], i);

			if (value != null && i - value <= k)
				return true;
		}
		return false;
	}

}
