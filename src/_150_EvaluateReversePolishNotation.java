import java.util.Stack;

/*Evaluate the value of an arithmetic expression in Reverse Polish Notation.
https://en.wikipedia.org/wiki/Reverse_Polish_notation
Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/
public class _150_EvaluateReversePolishNotation {
	public static void main(String[] args) {
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		System.out.println(evalRPN(tokens));
	}

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			String cur = tokens[i];
			if (!isOperater(cur))
				stack.push(Integer.parseInt(cur));
			else {
				int tempRes = 0;
				if (cur.equals("+"))
					tempRes = stack.pop() + stack.pop();
				if (cur.equals("-"))
					tempRes = -stack.pop() + stack.pop();
				if (cur.equals("*"))
					tempRes = stack.pop() * stack.pop();
				if (cur.equals("/")) {
					int fenmu = stack.pop();
					int fenzi = stack.pop();
					tempRes = fenzi / fenmu;
				}
				stack.push(tempRes);

			}

		}
		return stack.peek();
	}

	private static boolean isOperater(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}

}
