package hashset;
import java.util.HashSet;

/*Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
 "pwke" is a subsequence and not a substring.*/

//����
//https://leetcode.com/articles/longest-substring-without-repeating-characters/
public class _3_LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			max = max > getMax(s, i) ? max : getMax(s, i);
		}
		return max;
	}

	private int getMax(String s, int i) {
		HashSet<Character> set = new HashSet<Character>();
		boolean isRepeated = false;
		// 注意&&的截断问题
		for (int j = i; !isRepeated && j < s.length(); j++) {
			char cur = s.charAt(j);
			if (!set.contains(cur))
				set.add(cur);
			else {
				isRepeated = true;
			}
		}
		return set.size();
	}
}
