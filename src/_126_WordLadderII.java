import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*Given two words (beginWord and endWord), and a dictionary's word list, 
find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.*/
//answer
public class _126_WordLadderII {
	public List<List<String>> findLadders(String begin, String end, Set<String> dict) {
		List<List<String>> ret = new ArrayList<>();
		Queue<Item> queue = new LinkedList<>();
		Item first = new Item(begin, 1);
		queue.add(first);
		first.list.add(begin);

		Set<String> visited = new HashSet<>();

		int min = Integer.MAX_VALUE;
		int preSteps = 0;
		while (!queue.isEmpty()) {
			Item cur = queue.poll();
			if (cur.s.equals(end)) {
				if (cur.n <= min) {
					min = cur.n;
					ret.add(cur.list);
				}
			}
			if (cur.n > min)
				break;
			if (cur.n > preSteps)
				dict.removeAll(visited);
			preSteps = cur.n;

			char[] cc = cur.s.toCharArray();
			for (int i = 0; i < cc.length; i++) {
				char old = cc[i];
				for (char j = 'a'; j <= 'z'; j++) {
					cc[i] = j;
					String newS = new String(cc);
					if (cur.s.equals(newS) || !dict.contains(newS))
						continue;
					visited.add(newS);
					Item newItem = new Item(newS, cur.n + 1);
					newItem.list.addAll(cur.list);
					newItem.list.add(newS);
					queue.add(newItem);
				}
				cc[i] = old;
			}
		}
		return ret;
	}

	class Item {
		String s;
		int n;
		List<String> list;

		public Item(String s, int n) {
			this.s = s;
			this.n = n;
			list = new ArrayList<>();
		}
	}

}
