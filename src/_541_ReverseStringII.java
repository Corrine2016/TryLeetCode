/*Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]*/

/**
 * @author Corrine
 *
 */
public class _541_ReverseStringII {
	public String reverseStr(String s, int k) {

		StringBuffer res = new StringBuffer();
		String convert = "";
		if (s.length() < 2 * k)
			convert = s;
		else
			convert = s.substring(0, 2 * k);
		StringBuffer temp = new StringBuffer();
		temp.append(convert.substring(0, Math.min(k, s.length()))).reverse();
		if (convert.length() > k)
			temp.append(convert.substring(k));
		res.append(temp.toString());
		if (s.length() > 2 * k)
			res.append(reverseStr(s.substring(2 * k), k));
		return res.toString();

	}
}
