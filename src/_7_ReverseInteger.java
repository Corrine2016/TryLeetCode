/*Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321*/

public class _7_ReverseInteger {
	public static void test() {
		int x = -21;
		System.out.println(reverse(x));

	}

	public static int reverse(int x) {
		int result = 0;
		if (x > Integer.MAX_VALUE)
			return 0;
		if (x >= 0) {
			StringBuffer sBuffer = new StringBuffer(Integer.toString(x));
			String reString = sBuffer.reverse().toString().trim();
			try {
				result = Integer.parseInt(reString);
			} catch (Exception ex) {
				System.out.println("error");
				return 0;
			}

		}
		if (x < 0) {
			StringBuffer sBuffer = new StringBuffer(Integer.toString(x)
					.replace("-", ""));
			String reString = "-" + sBuffer.reverse().toString();
			try {
				result = Integer.parseInt(reString);
			} catch (Exception ex) {
				System.out.println("error");
				return 0;
			}

		}
		System.out.println(result);

		return result;
	}
}
