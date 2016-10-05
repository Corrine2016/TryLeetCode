//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.
//
//Note:
//Have you consider that the string might be empty? This is a good question to ask during an interview.
//
//For the purpose of this problem, we define empty string as valid palindrome.

//总结超时原因，不要写太多的判断，会超时
public class _125_ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("aA"));
	}

	// time limited exceeded
	// public static boolean isPalindrome(String s) {
	// if (s == null)
	// return true;
	// else {
	// String temp = "";
	// char[] charArray = s.toLowerCase().toCharArray();
	// for (int i = 0; i < charArray.length; i++) {
	// if ((charArray[i] >= 'a' && charArray[i] <= 'z') || (charArray[i] >= '0'
	// && charArray[i] <= '9')) {
	// temp = temp + charArray[i];
	// }
	//
	// }
	// System.out.println(temp);
	// StringBuffer stringBuffer = new StringBuffer(temp);
	// if (stringBuffer.reverse().toString().compareTo(temp) == 0)
	// return true;
	// }
	// return false;
	// }

	// time limited exceeded
	// public static boolean isPalindrome(String s) {
	// if (s == null)
	// return true;
	// else {
	//
	// char[] charArray = s.toCharArray();
	// String temp = "";
	// for (int i = 0; i < charArray.length; i++) {
	// if ((charArray[i] >= 'a' && charArray[i] <= 'z') || (charArray[i] >= '0'
	// && charArray[i] <= '9')
	// || (charArray[i] >= 'A' && charArray[i] <= 'Z'))
	// temp = temp + (charArray[i] + "").toLowerCase();
	// }
	// System.out.println(temp);
	// char[] tempArray = temp.toCharArray();
	// int i = 0, j = tempArray.length - 1;
	// while (i <= j) {
	// if (tempArray[i] != tempArray[j])
	// return false;
	//
	// i++;
	// j--;
	// }
	// }
	// return true;
	// }

	// // 绝望了，还是超时
	// public static boolean isPalindrome(String s) {
	// if (s == null)
	// return true;
	// else {
	//
	// String temp = "";
	// for (int i = 0; i < s.length(); i++) {
	// if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' &&
	// s.charAt(i) <= '9')
	// || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'))
	// temp = temp + (s.charAt(i) + "").toLowerCase();
	// }
	//
	// int i = 0, j = temp.length() - 1;
	// while (i <= j) {
	// if (temp.charAt(i) != temp.charAt(j))
	// return false;
	//
	// i++;
	// j--;
	// }
	// }
	// return true;
	// }

	public static boolean isPalindrome(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "");
		s = s.toLowerCase();
		int j = s.length() - 1;
		int i = 0;
		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

}
