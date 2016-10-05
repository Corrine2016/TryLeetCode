/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
  return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.*/
public class _58_LengthOfLastWord {
	public static void main(String[] args) {
		String s = "H";
		System.out.println(lengthOfLastWord(s));

	}

	public static int lengthOfLastWord(String s) {
		String[] split = s.split(" ");

		if (split.length == 0)
			return 0;
		else
			return split[split.length - 1].toCharArray().length;

	}

}
