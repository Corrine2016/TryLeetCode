package Hashset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _1_a {
	public static void main(String[] args) {
		_1_a obj = new _1_a();
		int[] nums = new int[] { 2, 3, 1, 1, 4 };
		int val = 8;
		String string = "wordgoodgoodgoodbestword";
		String[] words = new String[] { "c", "c" };
		System.out.println(obj.isAnagrams("pup", "pup"));

		// System.out.println(obj.findSubstring(string, words));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		for (String str : strs) {

			boolean isAdded = false;
			for (int i = 0; i < res.size(); i++) {
				List<String> temp = res.get(i);
				if (isAnagrams(temp.get(0), str)) {
					temp.add(str);
					isAdded = true;
				}
			}
			if (!isAdded) {
				ArrayList<String> temp = new ArrayList<>();
				temp.add(str);
				res.add(temp);
			}
		}
		return res;

	}

	private boolean isAnagrams(String src, String target) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : src.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		// System.out.println(map);
		for (char ch : target.toCharArray()) {
			if (!map.containsKey(ch) || map.get(ch) < 1)
				return false;
			else {
				map.put(ch, map.get(ch) - 1);
			}
		}
		for (char ch : map.keySet()) {
			if (map.get(ch) != 0)
				return false;
		}

		return true;
	}
}
