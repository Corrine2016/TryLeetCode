import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 add spaces in s to construct a sentence where each word is a valid dictionary word.
 You may assume the dictionary does not contain duplicate words.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].*/
//answer
public class _140_WordBreakII {
	// public static List<String> wordBreak(String s, List<String> wordDict) {
	// List<String> reStrings = new ArrayList<String>();
	// helper(reStrings, s, wordDict, 0, "");
	// return reStrings;
	//
	// }
	//
	// private static void helper(List<String> reStrings, String s, List<String>
	// wordDict, int start, String temp) {
	// if (start == s.length()) {
	// reStrings.add(temp.trim());
	// }
	// for (int i = s.length(); i > start; i--) {
	// String sub = s.substring(start, i);
	// if (wordDict.contains(sub)) {
	//
	// temp = temp + sub + " ";
	// helper(reStrings, s, wordDict, i, temp);
	// temp = temp.substring(0, temp.length() - sub.length() - 1);
	// }
	// }
	//
	// }
	public List<String> wordBreak(String s, List<String> wordDict) {
		return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}

	// DFS function returns an array including all substrings derived from s.
	List<String> DFS(String s, List<String> wordDict,
			HashMap<String, LinkedList<String>> map) {
		if (map.containsKey(s))
			return map.get(s);

		LinkedList<String> res = new LinkedList<String>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> sublist = DFS(s.substring(word.length()),
						wordDict, map);
				for (String sub : sublist)
					res.add(word + (sub.isEmpty() ? "" : " ") + sub);
			}
		}
		map.put(s, res);
		return res;
	}
}
