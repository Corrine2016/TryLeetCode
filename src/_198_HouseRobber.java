//You are a professional robber planning to rob houses along a street.
//Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses
//have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can 
//rob tonight without alerting the police.

/*http://blog.csdn.net/pistolove/article/details/47680663
 思路：
 （1）这道题很有意思，在这里就不翻译成中文了。将题目内容转化为通俗易懂的形式为：给定一个整数数组Arr，求解数组中连续的不相邻元素的和的最大值。例如：对于数组中的元素A1,A2,A3,A4，则需要判断A1+A3,A1+A4,A2+A4中的最大值即为所求。
 （2）该题是一道简单动态规划相关的题目，如果能够正确地找到其中的递推关系，那么该题就很容易了。对于n个数的数组，如果要求得其连续不相邻元素的最大值，那么我们只需求得n-1个数的最大值，以及求得n-2个数的最大值即可，这样就形成了求解该问题的子问题的最大值问题，
 所以很容易考虑出递推关系，假设数组为Arr[]，n个数的数组对应的不相邻连续元素的最大值用函数f(n)表示，则有f(n) = max{f(n-1), f(n-2)+A[n-1]}，其中n>=2，f(n)也称为递推关系。其中f(n-1)为n-1个元素的最大值，f(n-2)+Arr[n-1]为n-2个元素的最大值加上数组第n个元素的值，
 因为要求元素不能相邻，所以会跳过第n-1个元素，这个应该很好理解。对动态规划感兴趣的同学可以看看网上有关动态规划的文章，个人觉得很有必要学习动态规划的思想。*/
public class _198_HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {};
		System.out.println(rob(nums));
	}

	public static int rob(int[] nums) {
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
			maxMoney[i] = Math.max(maxMoney[i - 2] + nums[i - 1],
					maxMoney[i - 1]);
		}
		return maxMoney[len];
	}
}
