import java.util.Stack;

/*Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"*/

/*会用到大概以下一些规则：

. 代表当前目录；
.. 代表上一级目录；
注意：它们单独使用才具有特殊意义，比如 /..abc/ 中的 “..”就没有特殊意义，不应该被简化掉。

比如：

路径 /home/ 简化成 /home；
路径 /../ 简化成 /；
路径 /home//foo/ 简化成 /home/foo；
路径 /a/./b/../../c/ 简化成 /c；
路径 /... 简化成 /...；
路径 /.hidden 简化成 /.hidden；
路径 /. 简化成 /.；
...
*/
public class _71_SimplifyPath {
	public static void main(String[] args) {
		System.out.println(simplifyPath("/a/./b/../../c/ "));
	}

	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		while (path.length() > 0) {
			int start = path.indexOf("/"); // 第一个斜杠的位置
			path = path.substring(start + 1); // Path一进被截取
			int end = path.indexOf("/");// 第二个斜杠的位置
			if (end == -1)
				end = path.length();

			String part = path.substring(0, end);
			path = path.substring(end);

			System.out.println(part + " " + path);
			if (part.equals(".") || part.equals(""))
				continue;
			if (part.equals("..")) {
				if (stack.isEmpty() == false)
					stack.pop();
			}

			else
				stack.push("/" + part);
		}
		String result = "";
		while (stack.isEmpty() == false) {
			result = stack.pop() + result;
		}
		if (result.length() == 0)
			result = "/";
		return result;
	}
}
