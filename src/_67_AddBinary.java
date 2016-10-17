//Given two binary strings, return their sum (also a binary string).
//
//For example,
//a = "111"
//b = "11"
//Return "1000".
public class _67_AddBinary {
	public static String addBinary(String a, String b) {
		char[] aCharArray = a.toCharArray();
		char[] bCharArray = b.toCharArray();
		String c = "";
		int grow = 0;
		for (int i = aCharArray.length - 1, j = bCharArray.length - 1, k = 0; i >= 0
				|| j >= 0; i--, j--, k++) {

			int x = i >= 0 ? Integer.parseInt(aCharArray[i] + "") : 0;
			int y = j >= 0 ? Integer.parseInt(bCharArray[j] + "") : 0;

			int z = (x + y + grow) % 2;
			grow = (x + y + grow) / 2;

			c = z + c;

			System.out.println(c);

		}
		if (grow == 1) {
			c = "1" + c;
		}
		if (c.charAt(0) == '2') {

			c = "10" + c.substring(1, c.length());

		}

		return c;
	}

	public static void main(String[] args) {
		String a = "1";
		String b = "111";
		System.out.println(addBinary(a, b));
	}

}
