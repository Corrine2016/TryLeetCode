//Write a function that takes an unsigned integer and returns the number of ¡¯1' bits it has (also known as the Hamming weight).
//
//For example, the 32-bit integer ¡¯11' has binary representation 00000000000000000000000000001011, so the function should return 3.
public class _191_Numberof1Bits {
	public static void main(String[] args) {
		System.out.println(hammingWeight(11));
	}

	public static int hammingWeight(int n) {
		int result = 0;
		String str = Integer.toBinaryString(n);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1')
				result++;
		}
		return result;
	}
}
