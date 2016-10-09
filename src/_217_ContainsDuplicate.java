import java.util.HashSet;

//Given an array of integers, find if the array contains any duplicates. 
//Your function should return true if any value appears at least twice in the array,
//		and it should return false if every element is distinct.
public class _217_ContainsDuplicate {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 3, 4, 5, 5 };
		System.out.println(containsDuplicate(nums));
	}

	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			hashSet.add(nums[i]);
		}
		if (hashSet.size() == nums.length) {
			return false;
		} else {
			return true;
		}

	}
}
