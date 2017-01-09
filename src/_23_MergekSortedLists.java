import java.util.ArrayList;
import java.util.Collections;

//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

/**
 * @author corrine
 *
 */
public class _23_MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < lists.length; i++) {
			ListNode temp = lists[i];
			ListNode runner = temp;
			while (runner != null) {
				list.add(runner.val);
				runner = runner.next;
			}
		}
		Collections.sort(list);
		ListNode res = new ListNode(-1);
		ListNode runner = res;
		for (int i = 0; i < list.size(); i++) {
			runner.next = new ListNode(list.get(i));
			runner = runner.next;
		}
		return res.next;
	}
}
