/*Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.*/
//answer

public class _42_TrappingRainWater {
	public int trap(int[] height) {
		int i = 0, j = height.length - 1, result = 0, plank = 0;
		while (i <= j) {
			plank = plank < Math.min(height[i], height[j]) ? Math.min(height[i], height[j]) : plank;
			result = height[i] >= height[j] ? result + (plank - height[j--]) : result + (plank - height[i++]);
		}
		return result;
	}
}
