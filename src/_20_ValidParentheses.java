import java.util.Stack;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

/*�������Ľⷨ�Ƚϼ򵥣�ֻҪ��һ��stack�Ϳ�����,���ǰ�s������ַ�һ��һ����һ�顣��Ҫ��Ϊ2�����

 1 �����������([{�����һ�������ǾͰ�����ַ�����stack���档
 2 �����������)]}�����һ�������ǾͰ�����ַ���stack��˵��ַ����бȽ�
 (a)����������ַ���stack�����ַ���ȣ����ǰ�stack���˵��ַ�ȥ����Ȼ������Ƚ��ַ�������һ��
 (b)����������ַ���stack���˵Ĳ���ȣ����Ǿͷ���false��

 �����ǰ�s������ַ���������һ���Ժ������ٿ�stack�ǲ��ǿգ�����վͷ���true�����վͷ���false��*/

public class _20_ValidParentheses {
	public static void main(String[] args) {
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
