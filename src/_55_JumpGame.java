/*Given an array of non-negative integers, you are initially positioned at the first
index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.*/
//https://leetcode.com/articles/jump-game/
//JumpGame2－４５
//answer 
public class _55_JumpGame {
	public boolean canJump(int[] A) {
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > max) {
				return false;
			}
			max = Math.max(A[i] + i, max);
		}
		return true;
	}
}
