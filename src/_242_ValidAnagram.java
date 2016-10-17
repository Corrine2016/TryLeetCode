import java.util.HashMap;
import java.util.Iterator;

/*Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.*/
public class _242_ValidAnagram {
	public static boolean isAnagram(String s, String t) {
		HashMap<Character, Integer> map1 = toMap(s);
		HashMap<Character, Integer> map2 = toMap(t);
		System.out.println(map1);
		System.out.println(map2);
		Iterator<Character> iterator1 = map1.keySet().iterator();
		while (iterator1.hasNext()) {
			Character key = iterator1.next();
			if (!map2.containsKey(key) || map2.get(key).compareTo(map1.get(key)) != 0)
				return false;
		}
		Iterator<Character> iterator2 = map2.keySet().iterator();
		while (iterator2.hasNext()) {
			Character key = iterator2.next();
			if (!map1.containsKey(key) || map2.get(key).compareTo(map1.get(key)) != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "a";
		String t = "ab";
		System.out.println(isAnagram(s, t));
	}

	private static HashMap<Character, Integer> toMap(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), 1);
			else
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);

		}
		return map;
	}
}

// public boolean isAnagram(String s, String t) {
// if (s.length() != t.length()) {
// return false;
// }
// char[] str1 = s.toCharArray();
// char[] str2 = t.toCharArray();
// Arrays.sort(str1);
// Arrays.sort(str2);
// return Arrays.equals(str1, str2);
// }