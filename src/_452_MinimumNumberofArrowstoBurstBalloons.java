import java.util.Arrays;

/*There are a number of spherical balloons spread in two-dimensional space. For each balloon,
provided input is the start and end coordinates of the horizontal diameter.
Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis.
A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.

Example:

Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).*/
//answer
/*初始化为1，因为气球数量不为0，所以怎么也得先来一发啊，
然后这一箭能覆盖的最远位置就是第一个气球的结束点，用变量end来表示。
然后我们开始遍历剩下的气球，如果当前气球的开始点小于等于end，说明跟之前的气球有重合，
之前那一箭也可以照顾到当前的气球，此时我们要更新end的位置，end更新为两个气球结束点之间较小的那个，
这也是当前气球和之前气球的重合点，然后继续看后面的气球；
如果某个气球的起始点大于end了，说明前面的箭无法覆盖到当前的气球，那么就得再来一发，
既然又来了一发，那么我们此时就要把end设为当前气球的结束点了*/
public class _452_MinimumNumberofArrowstoBurstBalloons {
	public int findMinArrowShots(int[][] points) {
		if (points == null || points.length == 0)
			return 0;
		// 优先按照起点位置排序，然后按照结束位置排序
		Arrays.sort(points, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
		int count = 1;
		int arrowLimit = points[0][1];
		// 贪心法，基于上一个箭，记录当前能够射穿的所有
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] <= arrowLimit) {
				arrowLimit = Math.min(arrowLimit, points[i][1]);
			} else {
				count++;
				arrowLimit = points[i][1];
			}
		}
		return count;
	}
}
