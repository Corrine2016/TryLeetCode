/*Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 */
public class _171_ExcelSheetColumnNumber {
	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));

	}

	public static int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			int m = s.charAt(s.length() - 1 - i) - 'A' + 1;
			result = result + (int) (m * Math.pow(26.0, i));

		}

		return result;
	}
}
