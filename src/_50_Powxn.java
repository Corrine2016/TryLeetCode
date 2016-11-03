//Implement pow(x, n).
//https://discuss.leetcode.com/topic/21837/5-different-choices-when-talk-with-interviewers/2
public class _50_Powxn {
	public double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 1 / myPow(x, -(n + 1)) / x;
		double t = myPow(x, n >> 1);
		return ((n & 1) == 1 ? x : 1) * t * t;
	}
}
