//Write a function to find the longest common prefix string amongst an array of strings.
//解题思路是，先对整个String数组预处理一下，求一个最小长度（最长前缀肯定不能大于最小长度）。
//
//然后以第0个字符串作为参照，从第1个字符串到最后一个字符串，对同一位置做判断，有不同字符串返回当前记录的字符串就行。
public class _14_LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0 || strs == null)
			return "";

		for (int i = 0; i < strs[0].length(); i++) {
			char x = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() == i || strs[j].charAt(i) != x)
					return strs[0].substring(0, i);
			}
		}

		return strs[0];
	}

	public static void main(String[] args) {
		String[] strs = { "Hello", "He", "H" };
		System.out.println(longestCommonPrefix(strs));

	}

}
