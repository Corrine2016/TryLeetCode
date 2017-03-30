import java.util.HashMap;

/*
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j 
 * in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 */

/**
 * @author Corrine
 *
 */
public class _219_ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.keySet().contains(nums[i]))
				map.put(nums[i], i);
			else {
				if (i - map.get(nums[i]) <= k)
					return true;
				else {
					map.put(nums[i], i);
				}
			}
		}
		return false;
	}

}
