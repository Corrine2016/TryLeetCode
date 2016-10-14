/*Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.*/
public class _371_SumofTwoIntegers {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		System.out.println(getSum(a, b));
	}

	public static int getSum(int a, int b) {
		while ((a & b) != 0x00) {// check carry bit
			final int x = (a & b) << 1;// same bit has carry
			final int y = (a ^ b); // different bit
			a = x;
			b = y;
		}
		return a | b;

	}
}
