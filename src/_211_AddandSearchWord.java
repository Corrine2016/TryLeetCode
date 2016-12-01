import java.util.ArrayList;
import java.util.HashMap;

/*Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.*/
//answer
public class _211_AddandSearchWord {

}

class WordDictionary {
	public HashMap<Integer, ArrayList<String>> hm = new HashMap<Integer, ArrayList<String>>();

	// Adds a word into the data structure.
	public void addWord(String word) {
		int len = word.length();
		if (hm.containsKey(len))
			hm.get(len).add(word);
		else {
			ArrayList<String> arr = new ArrayList<String>();
			arr.add(word);
			hm.put(len, arr);
		}
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		int len = word.length();
		if (!hm.containsKey(len))
			return false;
		for (String w : hm.get(len)) {
			if (isSimilar(word, w, len))
				return true;
		}
		return false;
	}

	public boolean isSimilar(String w1, String w2, int len) {
		for (int i = 0; i < len; i++) {
			if (w1.charAt(i) != '.' && w1.charAt(i) != w2.charAt(i))
				return false;
		}
		return true;
	}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");