import java.util.Stack;

/*Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.*/
//answer
public class _84_LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		int max_area = 0, currentHeight, lastIndex, len;
		for (int i = 0; i < heights.length; i++) {
			currentHeight = heights[i];
			// 保持升序
			if (stack.isEmpty() || heights[stack.peek()] <= currentHeight) {
				stack.push(i);
				continue;
			}
			// 到了这里，就是不满足升序，需要弹出，注意当前len的判断方式
			while (stack.isEmpty() == false && heights[stack.peek()] > currentHeight) {
				lastIndex = stack.pop();
				len = stack.isEmpty() ? i : (i - stack.peek() - 1);
				max_area = Math.max(max_area, len * heights[lastIndex]);
			}
			stack.push(i);
		}
		// 最后需要多处理一次
		while (stack.isEmpty() == false) {
			lastIndex = stack.pop();
			len = stack.isEmpty() ? heights.length : (heights.length - stack.peek() - 1);
			max_area = Math.max(max_area, len * heights[lastIndex]);
		}
		return max_area;

	}
}
