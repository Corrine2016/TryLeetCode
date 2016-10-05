//Implement strStr().
//Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//给两个字符串A,B,判断B是否出现在A中，如果出现，返回第一次出现的位置指针，否则，返回NULL
public class _28_ImplementStrStr {
	public static void main(String[] args) {
		String haystack = "asdkHellosdfad";
		String needle = "Hello";
		System.out.println(strStr(haystack, needle));

	}

	public static int strStr(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}

	}

}
