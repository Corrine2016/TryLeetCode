import java.util.HashSet;

public class _1_a {

	public int lengthOfLongestSubstring(String s) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			max = max > getMax(s, i) ? max : getMax(s, i);
		}
		return max == Integer.MIN_VALUE ? 0 : max;
	}

	private int getMax(String s, int i) {
		HashSet<Character> set = new HashSet<Character>();
		boolean isRepeated = false;
		for (int j = i; isRepeated && j < s.length(); j++) {
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
