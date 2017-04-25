package hashset;
import java.util.HashMap;

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

/**
 * @author Corrine
 *
 */
public class _205_IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		if (s.length() != t.length())
			return false;
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (!map.keySet().contains(cur)) {
				if (map.values().contains(t.charAt(i)))
					return false;
				map.put(cur, t.charAt(i));
			} else {
				if (map.get(cur) != t.charAt(i))
					return false;
			}

		}

		return true;
	}
}
