/*Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.*/

/**
 * @author corrine
 *
 */
public class _151_ReverseWordsinaString {
	public static void main(String[] args) {
		System.out.println(reverseWords(" "));
	}

	public static String reverseWords(String s) {
		if (s.length() == 0)
			return s;
		s.trim();
		StringBuilder sBuilder = new StringBuilder();
		String sub = "";

		for (int i = s.length() - 1; i >= 0; i--) {
			char cur = s.charAt(i);
			if (cur != ' ') {
				sub = cur + sub;
			} else if (i > 0 && s.charAt(i - 1) != ' ') {

				sBuilder.append(sub);
				sBuilder.append(" ");
				sub = "";

			}
		}
		sBuilder.append(sub);

		return sBuilder.toString().trim();

	}
}
