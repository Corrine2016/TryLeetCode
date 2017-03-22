package array;

/*Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.*/
//JumpGame－5５
//answer
//思路是，curReach表示当前能跳到的最远距离，lastReach表示上次最远可以跳到的距离。
//那么，对于每次lastReach < i 时，说明跳上一次不到i，需要cnt++
public class _45_JumpGameII {
	public int jump(int[] A) {
		int curReach = 0, lastReach = 0, cnt = 0;
		for (int i = 0; i < A.length; i++) {

			if (lastReach < i) {
				lastReach = curReach;
				cnt++;
			}
			curReach = curReach < i + A[i] ? i + A[i] : curReach;
		}
		return cnt;
	}
}
