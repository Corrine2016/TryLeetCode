import java.util.ArrayList;
import java.util.List;

/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]*/
public class _22_GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> ret = new ArrayList();
		if (n == 0)
			return ret;
		helper(ret, new StringBuilder(), n, n);
		return ret;
	}

	private void helper(List<String> ret, StringBuilder sb, int left, int right) {
		if (left == 0 && right == 0) {
			ret.add(sb.toString());
		}
		if (left > 0) {
			int len = sb.length();
			helper(ret, sb.append("("), left - 1, right);
			sb.setLength(len);
		}
		if (left < right) {
			int len = sb.length();
			helper(ret, sb.append(")"), left, right - 1);
			sb.setLength(len);
		}
	}
}
