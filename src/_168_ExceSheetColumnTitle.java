/*Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class _168_ExceSheetColumnTitle {
	public static String convertToTitle(int n) {
		String result = "";
		while (n != 0) {
			result = (char) ((n - 1) % 26 + 'A') + result;
			n = (n - 1) / 26;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(convertToTitle(26));
	}

}
