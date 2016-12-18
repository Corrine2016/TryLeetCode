/*Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.*/

/**
 * @author corrine
 *
 */
public class _334_IncreasingTripletSubsequence {
	public static void main(String[] args) {
		int[] nums = new int[] { 5, 4, 3, 2, 1 };
		System.out.println(increasingTriplet(nums));
	}

	public static boolean increasingTriplet(int[] nums) {
		if (nums.length < 3)
			return false;
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (nums[j] > nums[i]) {
					for (int k = j + 1; k < nums.length; k++)
						if (nums[k] > nums[j])
							return true;
				}
			}
		}
		return false;

	}
}
