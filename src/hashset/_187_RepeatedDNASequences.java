package hashset;
import java.util.ArrayList;
import java.util.HashSet;
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
	public List<String> findRepeatedDnaSequences(String s) {
		HashSet<String> res = new HashSet<String>();
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < s.length() - 9; i++) {
			String temp = s.substring(i, i + 10);
			if (!set.contains(temp))
				set.add(temp);
			else
				res.add(temp);

		}

		return new ArrayList<String>(res);
	}
}
