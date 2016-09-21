import java.util.Stack;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

/*这个问题的解法比较简单，只要用一个stack就可以了,我们把s里面的字符一个一个过一遍。主要分为2种情况

1 如果我们遇到([{里面的一个，我们就把这个字符放入stack里面。
2 如果我们遇到)]}里面的一个，我们就把这个字符和stack最顶端的字符进行比较
(a)如果遇到的字符和stack顶端字符相等，我们把stack顶端的字符去掉，然后继续比较字符串的下一个
(b)如果遇到的字符和stack顶端的不相等，我们就返回false。

当我们把s里面的字符串都过了一遍以后，我们再看stack是不是空，如果空就返回true。不空就返回false。*/

public class _20_ValidParentheses {
	public static void test() {
		String string = "([])";
		System.out.println(isValid(string));

	}

	public static boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!stack.empty()) {
				switch (c) {
				case ')':
					if (stack.pop() != '(')
						return false;
					break;
				case '}':
					if (stack.pop() != '{')
						return false;
					break;
				case ']':
					if (stack.pop() != '[')
						return false;
					break;
				default:
					stack.push(c);
					break;
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty() == true;

	}

}
