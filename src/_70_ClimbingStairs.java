//You are climbing a stair case. It takes n steps to reach to the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
public class _70_ClimbingStairs {
	public static void test() {
		int n = 4;
		System.out.println(climbStairs(n));

	}
	// ²»¸øÐ´µÝ¹é£¬Ì«ÎÞ³Ü
	// public static int climbStairs(int n) {
	// if (n == 1)
	// return 1;
	// else if (n == 2)
	// return 2;
	// else
	// return climbStairs(n - 1) + climbStairs(n - 2);
	//
	// }

	public static int climbStairs(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int num_prev2 = 1;
		int num_prev = 2;
		int result = 0;
		for (int i = 3; i <= n; ++i) {
			result = num_prev2 + num_prev;
			num_prev2 = num_prev;
			num_prev = result;
		}
		return result;

	}
}
