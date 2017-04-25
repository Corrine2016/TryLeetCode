package hashset;

import java.util.HashMap;

public class _1_a {
	public static void main(String[] args) {
		_1_a obj = new _1_a();
		int[] nums = new int[] { 1, 0, 1, 1 };
		int val = 8;
		String s = "ab";
		String t = "aa";
		System.out.println(obj.containsNearbyDuplicate(nums, 1));

	}

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
