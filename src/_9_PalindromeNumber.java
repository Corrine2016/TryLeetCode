//Determine whether an integer is a palindrome. Do this without extra space.
public class _9_PalindromeNumber {
	public static boolean isPalindrome(int x) {
		boolean result = false;
		String str = x + "";
		StringBuffer stringBuffer = new StringBuffer(str);
		String strRev = stringBuffer.reverse().toString();
		if (str.compareTo(strRev) == 0)
			result = true;
		return result;

	}

	public static void main(String[] args) {
		int num = 23;
		System.out.println(isPalindrome(num));

	}
}
