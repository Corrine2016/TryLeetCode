//Implement strStr().
//Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//�������ַ���A,B,�ж�B�Ƿ������A�У�������֣����ص�һ�γ��ֵ�λ��ָ�룬���򣬷���NULL
public class _28_ImplementStrStr {
	public static void test() {
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
