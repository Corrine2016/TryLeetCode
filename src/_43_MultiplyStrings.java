/*Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:

    The numbers can be arbitrarily large and are non-negative.
    Converting the input string to integer is NOT allowed.
    You should NOT use internal library such as BigInteger.*/

//https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation
//Remember how we do multiplication?
//
//Start from right to left, perform multiplication on every pair of digits, and add them together. Let's draw the process! From the following draft, we can immediately conclude:
//
// `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]` 

public class _43_MultiplyStrings {

	public String multiply(String num1, String num2) {
		int m = num1.length(), n = num2.length();
		int[] pos = new int[m + n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j, p2 = i + j + 1;
				int sum = mul + pos[p2];

				pos[p1] += sum / 10;
				pos[p2] = (sum) % 10;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int p : pos)
			if (!(sb.length() == 0 && p == 0))
				sb.append(p);
		return sb.length() == 0 ? "0" : sb.toString();
	}
}
