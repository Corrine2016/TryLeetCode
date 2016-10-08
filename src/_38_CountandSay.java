/*The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.*/

/*n=1 ����1

n=2����n=1�Ľ��Ϊ1����1��1�����Է���11

n=3����n=2���Ϊ11����2��1������21

n=4����n=3���Ϊ21����1��2��1��1�����Է���1211

����n,�Դ�����
˼·��������һ���ַ���= ���ڵ�ǰ�ַ�������(�ַ�����+�ַ�)

����1211����һ���ַ�������count(1)+'1'+count(2)+'2'+count(1)+'1'=111221*/
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
