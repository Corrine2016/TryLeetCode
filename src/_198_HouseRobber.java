//You are a professional robber planning to rob houses along a street.
//Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses
//have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can 
//rob tonight without alerting the police.

//http://blog.csdn.net/pistolove/article/details/47680663
// 213. House Robber II
public class _198_HouseRobber {

	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int[] maxMoney = new int[len + 1];
		if (len == 1) {
			return nums[0];
		}
		maxMoney[1] = nums[0];
		maxMoney[2] = Math.max(nums[0], nums[1]);
		for (int i = 3; i < len + 1; i++) {
			maxMoney[i] = Math.max(maxMoney[i - 2] + nums[i - 1], maxMoney[i - 1]);
		}
		return maxMoney[len];
	}
}
