package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _1_a {
	public static void main(String[] args) {
		_1_a obj = new _1_a();
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
		System.out.println(obj.threeSum(nums));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			int target = nums[i];
			int[] nums2 = new int[nums.length - 1];
			for (int j = 0; j < nums.length - 1; j++) {
				if (j == i) {

					continue;
				}
				nums2[j] = nums[j];
			}
			// System.out.println(Arrays.toString(nums2));
			List<List<Integer>> lists = twoSum(nums2, -target);
			// System.out.println(lists);
			for (List<Integer> list : lists) {
				list.add(target);
			}
			res.addAll(lists);
		}
		System.out.println(res);
		List<List<Integer>> finalres = new ArrayList<List<Integer>>();
		for (List<Integer> list : res) {
			boolean isExist = false;
			for (List<Integer> finallist : finalres) {
				if (isEqual(list, finallist))
					isExist = true;
			}
			if (!isExist)
				finalres.add(list);
		}
		return finalres;
	}

	private boolean isEqual(List<Integer> list, List<Integer> finallist) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (Integer i : list)
			set.add(i);
		for (Integer i : finallist)
			set.remove(i);
		return set.size() == 0 ? true : false;
	}

	public List<List<Integer>> twoSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int cur = nums[i];
			if (map.containsKey(target - cur)) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(cur);
				list.add(target - cur);
				res.add(list);
			} else {
				map.put(cur, i);
			}
		}
		return res;
	}
}
