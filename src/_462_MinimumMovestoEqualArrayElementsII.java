import java.util.Arrays;

/*Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]*/

/**
 * @author corrine
 *
 */
public class _462_MinimumMovestoEqualArrayElementsII {
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		if (nums.length < 2)
			return 0;
		int countLow = 0;
		int countHigh = 0;
		int low = nums.length / 2 - 1;
		int high = nums.length / 2;
		for (int i = 0; i < nums.length; i++) {
			countLow += Math.abs(nums[i] - nums[low]);
			countHigh += Math.abs(nums[i] - nums[high]);
		}

		return Math.min(countLow, countHigh);

	}
}
