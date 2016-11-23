import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].*/

/**
 * @author corrine
 *
 */
public class _187_RepeatedDNASequences {
	public static void main(String[] args) {
		String string = "  ";
		System.out.println(findRepeatedDnaSequences(string));

	}

	public static List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i <= s.length() - 10; i++) {
			String sub = s.substring(i, i + 10);
			if (!map.containsKey(sub))
				map.put(sub, 1);
			else {
				map.put(sub, map.get(sub) + 1);
				if (!res.contains(sub))
					res.add(sub);
			}
		}
		return res;
	}
}
