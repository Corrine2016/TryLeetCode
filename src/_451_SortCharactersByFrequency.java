import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.*/
//answer
public class _451_SortCharactersByFrequency {
	public static void main(String[] args) {
		System.out.println(frequencySort("dbac"));
	}

	public static String frequencySort(String s) {
		int maxCount = 0;

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (!map.containsKey(temp)) {
				map.put(temp, 1);

			} else {
				map.put(temp, map.get(temp) + 1);
			}

			maxCount = Math.max(maxCount, map.get(temp));

		}
		System.out.println(map);
		System.out.println(maxCount);

		List<Character>[] array = new List[maxCount + 1];
		for (Character c : map.keySet()) {
			int count = map.get(c);
			if (array[count] == null) {
				array[count] = new ArrayList();
			}
			array[count].add(c);
		}
		System.out.println(Arrays.toString(array));

		StringBuilder sb = new StringBuilder();
		for (int i = array.length - 1; i > 0; i--) {
			List<Character> list = array[i];
			if (list != null) {
				for (Character c : list) {
					for (int j = 0; j < i; j++) {
						sb.append(c);
					}
				}
			}
		}
		return sb.toString();
	}
}
