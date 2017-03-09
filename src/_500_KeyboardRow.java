import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a List of words, return the words that can be typed using letters of alphabet on only 
		one row's of American keyboard like the image below.


American keyboard


Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
Note:
You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.
*/

/**
 * @author corrine
 *
 */
public class _500_KeyboardRow {
	public String[] findWords(String[] words) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if (isKeyboard(words[i].toUpperCase())) {
				list.add(words[i]);
			}
		}
		return list.toArray(new String[list.size()]);

	}

	private boolean isKeyboard(String s) {
		List<String>[] lists = new List[3];
		lists[0] = Arrays.asList("Z", "X", "C", "V", "B", "N", "M");
		lists[1] = Arrays.asList("A", "S", "D", "F", "G", "H", "J", "K", "L");
		lists[2] = Arrays.asList("Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P");
		int line = 3;
		for (int i = 0; i < s.length(); i++) {
			String temp = "" + s.charAt(i);
			for (int j = 0; j < 3; j++) {
				if (lists[j].contains(temp)) {
					if (line == 3)
						line = j;
					else if (line != j)
						return false;
				}
			}
		}

		return true;

	}
}
