import java.util.TreeSet;

/*Given an array of integers, find out whether there are two distinct indices i and j in 
the array such that the difference between nums[i] and nums[j] 
is at most t and the difference between i and j is at most k.*/
//answer
public class _220_ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return false;
		}

		final TreeSet<Integer> values = new TreeSet<>();
		for (int ind = 0; ind < nums.length; ind++) {

			final Integer floor = values.floor(nums[ind] + t);
			final Integer ceil = values.ceiling(nums[ind] - t);
			if ((floor != null && floor >= nums[ind]) || (ceil != null && ceil <= nums[ind])) {
				return true;
			}

			values.add(nums[ind]);
			if (ind >= k) {
				values.remove(nums[ind - k]);
			}
		}

		return false;
	}
}
