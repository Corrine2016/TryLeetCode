/*Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.*/
/*使用滑动窗口的思路可以在O(n)时间复杂度的情况下解决这个问题。
需要记录当前窗口内各个字符的计数值（可以看做分布情况）以及当前窗口的起始点，
窗口内最多字符的计数best。我们知道，最多字符的计数best+修改数量k如果还是不能使得当前窗口内的字符都统一的话，
就得把窗口缩小（起始点后挪）。窗口缩小时记得把窗口计数更新一下。*/
//answer
//https://discuss.leetcode.com/topic/63494/java-12-lines-o-n-sliding-window-solution-with-explanation
public class _424_LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		int len = s.length();
		int[] count = new int[26];
		int start = 0, maxCount = 0, maxLength = 0;
		for (int end = 0; end < len; end++) {
			maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
			while (end - start + 1 - maxCount > k) {
				count[s.charAt(start) - 'A']--;
				start++;
			}
			maxLength = Math.max(maxLength, end - start + 1);
		}
		return maxLength;
	}
}
