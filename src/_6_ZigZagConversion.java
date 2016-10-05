/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".*/

/*˼�룺1����Rows������������ۣ���Rows=1�����ַ���text�ĳ���<nRows����ô����ȷ���ַ�������˳�������

 2�����nRows=2����ô����Ҫ���text�ַ���ż��λ���ϵ���ĸ��Ȼ��������λ���ϵ���ĸ��

 3�����nRows>2���ַ�������>nRows,���һ��mark��������������ַ������ڵڼ��У�����mark[k]=i,��˼�ǵ�K����ĸ���ڵ�i�С�
 ͨ������һboolean����bool���������ַ����ƶ�����ͨ������i�����ƻ��С�

 4��������mark��������е����ݣ��ֱ���ӵ�0�С�1��һֱ��nRows�е���ĸ��str�У������ء�
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
