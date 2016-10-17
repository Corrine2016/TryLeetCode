/*Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".*/
public class _345_ReverseVowelsofaString {

	public boolean isvowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U';
	}

	public String reverseVowels(String s) {
		StringBuffer p = new StringBuffer(s);
		int left = 0;
		int right = p.length() - 1;
		while (left < right) {
			if (isvowel(p.charAt(left)) && isvowel(p.charAt(right))) {
				char a = p.charAt(right), b = p.charAt(left);
				p.setCharAt(left, a);
				p.setCharAt(right, b);
				left++;
				right--;
			} else if (isvowel(p.charAt(left))) {
				right--;
			} else if (isvowel(p.charAt(right))) {
				left++;
			} else {
				left++;
				right--;
			}

		}
		return p.toString();
	}
}
