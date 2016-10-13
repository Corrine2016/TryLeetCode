import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern
and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters
separated by a single space*/
public class _290_WordPattern {
	public static void main(String[] args) {
		String pattern = "abba";
		String str = "dog dog dog dog";
		System.out.println(wordPattern(pattern, str));
	}

	public static boolean wordPattern(String pattern, String str) {
		String[] strings = str.split(" ");
		if (pattern.length() != strings.length)
			return false;

		HashMap<Character, ArrayList<Integer>> pMap = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			if (!pMap.containsKey(pattern.charAt(i))) {
				ArrayList<Integer> value = new ArrayList<>();
				value.add(i);
				pMap.put(pattern.charAt(i), value);
			} else {
				pMap.get(pattern.charAt(i)).add(i);

			}
		}
		// System.out.println(pMap);

		Iterator<Character> iterator = pMap.keySet().iterator();
		HashSet<String> outSet = new HashSet<>();
		while (iterator.hasNext()) {
			ArrayList<Integer> list = pMap.get(iterator.next());
			HashSet<String> set = new HashSet<>();
			String tString = "";
			for (Integer i : list) {
				set.add(strings[i]);
				tString = strings[i];
			}
			if (set.size() > 1) {
				return false;
			} else {
				outSet.add(tString);
			}
		}

		if (outSet.size() != pMap.size())
			return false;

		return true;

	}

	// public boolean wordPattern(String pattern, String str) {
	// String[] words = str.split(" ");
	// if (words.length != pattern.length())
	// return false;
	// Map index = new HashMap();
	// for (Integer i=0; i<words.length; ++i)
	// if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
	// return false;
	// return true;
	// }
}
