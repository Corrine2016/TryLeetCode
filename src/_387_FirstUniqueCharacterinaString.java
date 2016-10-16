import java.util.HashSet;

/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 Note: You may assume the string contain only lowercase letters.*/
public class _387_FirstUniqueCharacterinaString {
	public static void main(String[] args) {
		System.out.println(firstUniqChar("loeleetcode"));
	}

	public static int firstUniqChar(String s) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {

			if (!set.contains(s.charAt(i))) {
				boolean isRepeat = false;

				for (int j = i + 1; j < s.length(); j++) {
					if (s.charAt(i) == s.charAt(j)) {
						isRepeat = true;
						break;
					}
				}
				if (isRepeat == false) {
					return i;
				} else {
					set.add(s.charAt(i));
				}

			}
		}
		return -1;

	}

}
