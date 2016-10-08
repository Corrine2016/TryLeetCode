/*The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.*/

/*n=1 返回1

n=2由于n=1的结果为1，有1个1，所以返回11

n=3由于n=2结果为11，有2个1，返回21

n=4由于n=3结果为21，有1个2和1个1，所以返回1211

给定n,以此类推
思路：对于下一个字符串= 对于当前字符串：∑(字符个数+字符)

例如1211，下一个字符串就是count(1)+'1'+count(2)+'2'+count(1)+'1'=111221*/
public class _38_CountandSay {
	public String countAndSay(int n) {
		if (n == 1)
			return "1";

		String preString = countAndSay(n - 1);
		char c = preString.charAt(0);
		int count = 1, strLen = preString.length();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < strLen; i++) {
			if (c != preString.charAt(i)) {
				sb.append(count).append(c);
				c = preString.charAt(i);
				count = 1;
			} else {
				count++;
			}
		}
		sb.append(count).append(c);

		return sb.toString();

	}

}
