import java.util.Stack;

/*Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".*/

/**
 * @author corrine
 *
 */
public class _394_DecodeString {
	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));

	}

	public static String decodeString(String s) {
		Stack<String> stack = new Stack<>();
		String num = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isLetter(ch)) {

				stack.push("" + ch);
			} else if (Character.isDigit(ch)) {
				num = num + ch;

			}

			else if (ch == '[') {
				// if (!stack.isEmpty() && stack.peek().equals("["))
				// stack.push("1");
				stack.push(num);
				num = "";
				stack.push("" + ch);
			}

			else if (ch == ']') {
				String temp = "";
				while (!stack.peek().equals("[")) {
					temp = stack.pop() + temp;
				}
				stack.pop();
				int duplicate = Integer.parseInt(stack.pop());
				System.out.println(duplicate);
				String string = "";
				for (int j = 0; j < duplicate; j++) {
					string = string + temp;
				}
				stack.push(string);
			}
		}
		String result = "";
		System.out.println(stack);
		while (!stack.isEmpty()) {
			result = stack.pop() + result;
		}
		return result;
	}
}
