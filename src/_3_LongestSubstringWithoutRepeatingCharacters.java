import java.util.HashSet;

/*Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
"pwke" is a subsequence and not a substring.*/

//¶Á´ð°¸
//https://leetcode.com/articles/longest-substring-without-repeating-characters/
public class _3_LongestSubstringWithoutRepeatingCharacters {
	public class Solution {
		// public int lengthOfLongestSubstring(String s) {
		// int n = s.length();
		// Set<Character> set = new HashSet<>();
		// int ans = 0, i = 0, j = 0;
		// while (i < n && j < n) {
		// // try to extend the range [i, j]
		// if (!set.contains(s.charAt(j))){
		// set.add(s.charAt(j++));
		// ans = Math.max(ans, j - i);
		// }
		// else {
		// set.remove(s.charAt(i++));
		// }
		// }
		// return ans;
		// }
		//
		public int lengthOfLongestSubstring(String s) {
			int max = 0;
			for (int i = 0; i < s.length(); i++) {
				max = getMax(s, i) > max ? getMax(s, i) : max;
			}
			return max;
		}

		private int getMax(String s, int i) {
			HashSet<Character> set = new HashSet<>();
			boolean isRepeated = false;
			int j = 0;
			while (!isRepeated && i + j < s.length()) {
				if (set.contains(s.charAt(i + j))) {
					isRepeated = true;
				} else {
					set.add(s.charAt(i + j));
					j++;
				}
			}
			return set.size();
		}
	}
}
