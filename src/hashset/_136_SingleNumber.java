package hashset;
//Given an array of integers, every element appears twice except for one. Find that single one.

/**
 * @author corrine
 *
 */
public class _136_SingleNumber {
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++)
			result ^= nums[i];
		return result;
	}
}
