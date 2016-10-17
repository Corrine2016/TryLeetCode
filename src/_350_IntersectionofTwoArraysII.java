import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/*Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that 
you cannot load all elements into the memory at once?*/
public class _350_IntersectionofTwoArraysII {
	private static HashMap<Integer, Integer> getMap(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], 1);
			else
				map.put(nums[i], map.get(nums[i]) + 1);
		}
		return map;
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0)
			return new int[0];

		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		map = getMap(nums1);
		map2 = getMap(nums2);

		Iterator<Integer> mapIterator = map2.keySet().iterator();
		while (mapIterator.hasNext()) {
			Integer key = mapIterator.next();
			if (map.containsKey(key)) {

				for (int k = 0; k < Math.min(map.get(key), map2.get(key)); k++)
					resultList.add(key);
			}

		}

		int[] result = new int[resultList.size()];
		Iterator<Integer> iterator = resultList.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			result[i] = iterator.next();
			i++;

		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1 };
		int[] nums2 = { 1, 1 };
		System.out.println(Arrays.toString(intersect(nums1, nums2)));

	}
}
