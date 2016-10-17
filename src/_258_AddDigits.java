/*Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.*/
public class _258_AddDigits {

	private static int Add(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count = count + Integer.parseInt(s.charAt(i) + "");
		}
		return count;

	}

	public static int addDigits(int num) {
		String s = num + "";

		while (true) {
			int temp = Add(s);
			if ((temp + "").length() == 1) {

				return temp;
			}
			s = temp + "";
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addDigits(38));

	}
}
