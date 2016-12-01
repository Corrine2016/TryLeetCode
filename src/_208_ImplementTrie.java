/*Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.*/
public class _208_ImplementTrie {

}

class TrieNode {
	// Initialize your data structure here.
	TrieNode[] next;
	boolean isWord;
	int R = 26; // radix 'a' - 'z'

	public TrieNode() {
		this.next = new TrieNode[R];
	}
}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		if (word == null || word.length() == 0)
			return;
		TrieNode node = root;
		int d = 0;
		while (d < word.length()) {
			int index = word.charAt(d) - 'a';
			if (node.next[index] == null)
				node.next[index] = new TrieNode();
			node = node.next[index];
			d++;
		}
		node.isWord = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		if (word == null || word.length() == 0)
			return false;
		TrieNode node = root;
		int d = 0;
		while (d < word.length()) {
			int index = word.charAt(d) - 'a';
			if (node.next[index] == null)
				return false;
			node = node.next[index];
			d++;
		}
		return node.isWord;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		if (prefix == null || prefix.length() == 0)
			return false;
		TrieNode node = root;
		int d = 0;
		while (d < prefix.length()) {
			int index = prefix.charAt(d) - 'a';
			if (node.next[index] == null)
				return false;
			node = node.next[index];
			d++;
		}
		return true;
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");