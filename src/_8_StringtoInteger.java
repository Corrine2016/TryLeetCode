//判断开头的正负号，判断是否为空，判断是否超过int范围,去除空格

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _8_StringtoInteger {
	public static void test() {
		String s = "  -0012a42";
		System.out.println(myAtoi(s));

	}

	public static int myAtoi(String str) {
		str = str.trim();
		System.out.println(str);
		int result = 0;
		if (str.length() == 0) {
			System.out.println("EmptyString");
		} else {

			String str2 = str;
			boolean isPos = true;
			if (str.length() > 0 && str.charAt(0) == '-') {
				isPos = false;
				str2 = str.substring(1, str.length());
			}
			if (str.length() > 0 && str.charAt(0) == '+') {
				isPos = true;
				str2 = str.substring(1, str.length());
			}

			boolean isNum = true;

			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNumMatcher = pattern.matcher(str2);
			if (!isNumMatcher.matches()) {
				isNum = false;
				System.out.println("Not a Num");
				return 0;
			}

			if (isNum) {
				if (isPos) {
					try {
						result = Integer.parseInt(str2);
					} catch (Exception ex) {
						System.out.println("error");
						return 0;
					}
				}

				else {
					try {
						result = Integer.parseInt("-" + str2);
					} catch (Exception ex) {
						System.out.println("error");
						return 0;
					}
				}

			}

		}
		return result;
	}
}
