/*Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".*/

//StringBuilder���ԣ��ַ������Ӳ����Գ�ʱ
public class _344_ReverseString {
	public String reverseString(String s) {
		StringBuilder result = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			result.append("" + s.charAt(i));
		}
		return result.toString();
	}
}
