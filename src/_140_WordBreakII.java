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
}
