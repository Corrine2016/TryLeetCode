import java.util.Arrays;

/*Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5*/

/**
 * @author corrine
 *
 */
public class _434_NumberofSegmentsinaString {
	public static void main(String[] args) {
		System.out.println(countSegments(""));
	}

	public static int countSegments(String s) {
		String[] strings = s.split(" ");
		System.out.println(Arrays.toString(strings));
		int count = 0;
		for (int i = 0; i < strings.length; i++) {
			if (!strings[i].equals(""))
				count++;
		}
		return count;
	}
}
