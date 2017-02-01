import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
 so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:
 Given words = ["bat", "tab", "cat"]
 Return [[0, 1], [1, 0]]
 The palindromes are ["battab", "tabbat"]
 Example 2:
 Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]*/
//answer hard 
//TLE
public class _336_PalindromePairs {
	public static void main(String[] args) {
		_336_PalindromePairs obj = new _336_PalindromePairs();
		String[] words = new String[] { "abcd", "dcba", "lls", "s", "sssll" };
		System.out.println(obj.palindromePairs(words));
	}

	//
	// public List<List<Integer>> palindromePairs(String[] words) {
	// List<List<Integer>> res = new ArrayList<List<Integer>>();
	// for (int i = 0; i < words.length; i++) {
	// for (int j = i + 1; j < words.length; j++) {
	// String curString = words[i] + words[j];
	// if (!isValidNum(curString))
	// continue;
	// if (isPalind(curString)) {
	// List<Integer> temp = new ArrayList<Integer>();
	// temp.add(i);
	// temp.add(j);
	// res.add(temp);
	// }
	// curString = words[j] + words[i];
	// if (isPalind(curString)) {
	// List<Integer> temp = new ArrayList<Integer>();
	// temp.add(j);
	// temp.add(i);
	// res.add(temp);
	// }
	//
	// }
	// }
	// return res;
	// }
	//
	// private boolean isValidNum(String curString) {
	// int[] counts = new int[26];
	// for (int i = 0; i < curString.length(); i++) {
	// counts[curString.charAt(i) - 'a']++;
	// }
	// int odd = 0;
	// for (int i = 0; i < 26; i++) {
	// if (counts[i] % 2 == 1)
	// odd++;
	// }
	// if (odd > 1)
	// return false;
	// return true;
	//
	// }
	//
	// private boolean isPalind(String curString) {
	// int i = 0, j = curString.length() - 1;
	// while (i <= j) {
	// if (curString.charAt(i++) != curString.charAt(j--))
	// return false;
	// }
	// return true;
	// }
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> ret = new ArrayList<>();
		if (words == null || words.length < 2)
			return ret;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++)
			map.put(words[i], i);
		for (int i = 0; i < words.length; i++) {
			// System.out.println(words[i]);
			for (int j = 0; j <= words[i].length(); j++) { // notice it should
															// be
															// "j <= words[i].length()"
				String str1 = words[i].substring(0, j);
				String str2 = words[i].substring(j);
				if (isPalindrome(str1)) {
					String str2rvs = new StringBuilder(str2).reverse()
							.toString();
					if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(map.get(str2rvs));
						list.add(i);
						ret.add(list);
						// System.out.printf("isPal(str1): %s\n",
						// list.toString());
					}
				}
				if (isPalindrome(str2)) {
					String str1rvs = new StringBuilder(str1).reverse()
							.toString();
					// check "str.length() != 0" to avoid duplicates
					if (map.containsKey(str1rvs) && map.get(str1rvs) != i
							&& str2.length() != 0) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(i);
						list.add(map.get(str1rvs));
						ret.add(list);
						// System.out.printf("isPal(str2): %s\n",
						// list.toString());
					}
				}
			}
		}
		return ret;
	}

	private boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left <= right) {
			if (str.charAt(left++) != str.charAt(right--))
				return false;
		}
		return true;
	}
}
