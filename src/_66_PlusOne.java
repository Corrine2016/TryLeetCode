//Given a non-negative number represented as an array of digits, plus one to the number.
//The digits are stored such that the most significant digit is at the head of the list.
public class _66_PlusOne {
	public static void test() {
		int[] digits = { 9, 9, 9 };
		int[] result = plusOne(digits);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

	public static int[] plusOne(int[] digits) {

		if (digits.length == 0) {
			digits[0] = 1;
		} else {

			digits[digits.length - 1]++;

			for (int i = digits.length - 1; i > 0; i--) {

				if (digits[i] > 9) {
					digits[i] = digits[i] % 10;
					digits[i - 1]++;
				}
			}

			if (digits[0] > 9) {

				int[] result = new int[digits.length + 1];
				result[0] = 1;
				result[1] = digits[0] % 10;
				for (int i = 2; i < result.length; i++) {
					result[i] = digits[i - 1];

				}
				return result;
			}

		}
		return digits;
	}
}
