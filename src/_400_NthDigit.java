/*Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.*/
public class _400_NthDigit {
	public static void main(String[] args) {
		System.out.println(findNthDigit(100));
	}

	// ��ʱ
	// public static int findNthDigit(int n) {
	// int sum = 0;
	// int temp = 1;
	// while (sum < n) {
	// char[] array = Integer.toString(temp).toCharArray();
	// if (sum + array.length >= n) {
	// for (int i = 1; i <= array.length; i++) {
	// if (sum + 1 == n)
	// return Integer.parseInt("" + array[i - 1]);
	// sum++;
	// }
	// } else {
	// sum += array.length;
	// temp++;
	// }
	// }
	// return -1;
	// }

	public static int findNthDigit(int n) {
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}
}
