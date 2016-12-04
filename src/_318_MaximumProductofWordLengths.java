/*Given a string array words, find the maximum value of length(word[i]) * length(word[j]) 
where the two words do not share common letters. You may assume that each word will contain 
only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.*/
//answer
public class _318_MaximumProductofWordLengths {
	public int maxProduct(String[] words) {
		int[] checker = new int[words.length];
		int max = 0;
		// populating the checker array with their respective numbers
		for (int i = 0; i < checker.length; i++) {
			int num = 0;
			for (int j = 0; j < words[i].length(); j++) {
				num |= 1 << (words[i].charAt(j) - 'a');
			}
			checker[i] = num;
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((checker[i] & checker[j]) == 0) // checking if the two
													// strings have common
													// character
					max = Math.max(max, words[i].length() * words[j].length());
			}
		}
		return max;
	}
}
