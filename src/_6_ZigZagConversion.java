/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".*/

/*思想：1、对Rows的情况进行讨论，当Rows=1或者字符串text的长度<nRows，那么可以确定字符串还是顺序输出；

 2、如果nRows=2，那么首先要获得text字符串偶数位置上的字母，然后获得奇数位置上的字母；

 3、如果nRows>2且字符串长度>nRows,设计一个mark数组用来标记在字符串会在第几行，比如mark[k]=i,意思是第K个字母会在第i行。
 通过设置一boolean变量bool，来控制字符串移动方向，通过设置i来控制换行。

 4、最后根据mark标记数组中的内容，分别添加第0行、1行一直到nRows行的字母到str中，并返回。
 */

public class _6_ZigZagConversion {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int num = 3;
		String result = zigZagConversion(s, num);
		char[] resultArray = result.toCharArray();
		for (int i = 0; i < resultArray.length; i++) {
			System.out.print(resultArray[i]);
		}
	}

	public static String zigZagConversion(String s, int nRows) {

		String str = "";
		if (0 == nRows || 1 == nRows || s.length() <= nRows)
			return s;
		if (2 == nRows) {
			for (int i = 0; i < s.length(); i += 2)
				str += s.charAt(i);
			for (int i = 1; i < s.length(); i += 2)
				str += s.charAt(i);
			return str;
		}

		int i = 0, k = 0;
		boolean bool = false;
		Integer[] mark = new Integer[s.length()];
		while (k < s.length()) {
			mark[k++] = i;
			if (i == nRows - 1) {
				bool = true;
			} else if (i == 0) {
				bool = false;
			}
			if (!bool)
				i++;
			else if (bool)
				i--;
		}

		k = 0;
		i = 0;
		while (i < nRows) {
			while (k < s.length()) {
				if (i == mark[k]) {
					str += s.charAt(k);
				}
				k++;
			}
			k = 0;
			i++;
		}
		return str;
	}
}
