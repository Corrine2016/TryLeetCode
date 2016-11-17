import java.util.Set;

/*Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

*/

//#answer
public class _139_WordBreak {

	public boolean wordBreak(String s, Set<String> wordDict) {
		int len = s.length();
		boolean[] f = new boolean[len + 1];
		f[0] = true;
		for (int i = 1; i < len + 1; i++)
			for (int j = 0; j < i; j++)
				if (f[j] && wordDict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
		return f[len];
	}
	// TLE
	// public static boolean wordBreak(String s, Set<String> wordDict) {
	//
	// return helper(s, wordDict, 0);
	//
	// }
	//
	// private static boolean helper(String s, Set<String> wordDict, int start)
	// {
	// System.out.println("start " + start);
	// if (start == s.length())
	// return true;
	// else {
	// boolean res = false;
	// for (int i = start + 1; i < s.length() + 1; i++) {
	// String temp = s.substring(start, i);
	// System.out.println(temp);
	// if (wordDict.contains(temp))
	// res = res | helper(s, wordDict, i);
	// }
	//
	// return res;
	//
	// }
	//
	// }
}
