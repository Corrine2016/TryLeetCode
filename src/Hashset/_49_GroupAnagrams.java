package Hashset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]*/

//https://discuss.leetcode.com/topic/22014/simple-java-solution
public class _49_GroupAnagrams {
	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(strs));

	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();

		Arrays.sort(strs);
		for (int i = 0; i < strs.length; i++) {
			String temp = strs[i];
			char[] ch = temp.toCharArray();
			Arrays.sort(ch);
			if (map.containsKey(String.valueOf(ch))) {
				map.get(String.valueOf(ch)).add(strs[i]);
			} else {
				List<String> each = new ArrayList<>();
				each.add(strs[i]);
				map.put(String.valueOf(ch), each);
			}
		}
		for (List<String> item : map.values()) {
			res.add(item);
		}
		return res;
	}

}
