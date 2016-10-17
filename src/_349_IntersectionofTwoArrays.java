import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/*Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.*/
public class _349_IntersectionofTwoArrays {

	public static int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0)
			return new int[0];

		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> resultSet = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		for (int j = 0; j < nums2.length; j++) {
			if (set.contains(nums2[j]))
				resultSet.add(nums2[j]);
		}
		int[] result = new int[resultSet.size()];
		Iterator<Integer> iterator = resultSet.iterator();
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
		System.out.println(Arrays.toString(intersection(nums1, nums2)));

	}
}
