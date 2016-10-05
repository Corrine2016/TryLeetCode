//Write a function to find the longest common prefix string amongst an array of strings.
//����˼·�ǣ��ȶ�����String����Ԥ����һ�£���һ����С���ȣ��ǰ׺�϶����ܴ�����С���ȣ���
//
//Ȼ���Ե�0���ַ�����Ϊ���գ��ӵ�1���ַ��������һ���ַ�������ͬһλ�����жϣ��в�ͬ�ַ������ص�ǰ��¼���ַ������С�
public class _14_LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = { "Hello", "He", "H" };
		System.out.println(longestCommonPrefix(strs));

	}

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

}
