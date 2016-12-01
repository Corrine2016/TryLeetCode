/*Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / 
operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5*/
//answer 
//https://discuss.leetcode.com/topic/17435/java-straight-forward-iteration-solution-with-comments-no-stack-o-n-o-1/2
public class _227_BasicCalculatorII {
	public int calculate(String s) {
		if (s == null)
			return 0;
		s = s.trim().replaceAll(" +", "");
		int length = s.length();

		int res = 0;
		long preVal = 0; // initial preVal is 0
		char sign = '+'; // initial sign is +
		int i = 0;
		while (i < length) {
			long curVal = 0;
			while (i < length && s.charAt(i) <= 57 && s.charAt(i) >= 48) { // int
				curVal = curVal * 10 + (s.charAt(i) - '0');
				i++;
			}
			if (sign == '+') {
				res += preVal; // update res
				preVal = curVal;
			} else if (sign == '-') {
				res += preVal; // update res
				preVal = -curVal;
			} else if (sign == '*') {
				preVal = preVal * curVal; // not update res, combine preVal &
											// curVal and keep loop
			} else if (sign == '/') {
				preVal = preVal / curVal; // not update res, combine preVal &
											// curVal and keep loop
			}
			if (i < length) { // getting new sign
				sign = s.charAt(i);
				i++;
			}
		}
		res += preVal;
		return res;
	}
}
