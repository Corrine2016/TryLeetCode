/*Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]*/
//wenhui
public class _453_MinimumMovestoEqualArrayElements {
	public int minMoves(int[] nums) {
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			min = min <= nums[i] ? min : nums[i];

		}
		return sum - min * nums.length;

	}
}
