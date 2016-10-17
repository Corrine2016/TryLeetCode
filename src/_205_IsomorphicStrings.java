import java.util.HashMap;
import java.util.Map;

//Given two strings s and t, determine if they are isomorphic.
//
//Two strings are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while 
//preserving the order of characters. No two characters may map to the same character 
//but a character may map to itself.
//
//For example,
//Given "egg", "add", return true.
//
//Given "foo", "bar", return false.
//
//Given "paper", "title", return true.
//
//Note:
//You may assume both s and t have the same length.
public class _205_IsomorphicStrings {

	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		for (Integer i = 0; i < s.length(); i++) {
			// the previous value associated with key, or null if there was no
			// mapping for key.
			// (A null return can also indicate that the map previously
			// associated null with key.)
			if (map1.put(s.charAt(i), i) != map2.put(t.charAt(i), i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		String s = "egg";
		String t = "add";
		System.out.println(isIsomorphic(s, t));

	}
}
