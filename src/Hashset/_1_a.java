package Hashset;

public class _1_a {
	public static void main(String[] args) {
		_1_a obj = new _1_a();
		int[] nums = new int[] { 2, 3, 1, 1, 4 };
		int val = 8;
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(obj.minWindow(s, t));
	}

	public String minWindow(String s, String t) {
		int j = 0, i = 0;
		int[] ks = new int[256];
		int[] kt = new int[256];
		int found = 0;
		String reString = "";
		int minLength = Integer.MAX_VALUE;
		for (char c : t.toCharArray()) {
			kt[c]++;
		}

		while (j < s.length()) {
			if (found < t.length()) {
				if (kt[s.charAt(j)] > 0) {
					ks[s.charAt(j)]++;
					if (ks[s.charAt(j)] <= kt[s.charAt(j)])
						found++;
				}
				j++;

			}
			while (found == t.length()) {
				if (j - i < minLength) {
					minLength = j - i;
					reString = s.substring(i, j);
				}
				if (kt[s.charAt(i)] > 0) {
					ks[s.charAt(i)]--;
					if (ks[s.charAt(i)] < kt[s.charAt(i)])
						found--;
				}
				i++;
			}
		}

		return reString;
	}

}
