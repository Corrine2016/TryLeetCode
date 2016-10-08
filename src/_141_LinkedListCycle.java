import java.util.HashSet;
import java.util.Set;

/*Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?*/
public class _141_LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		Set<ListNode> nodesSeen = new HashSet<>();
		while (head != null) {
			if (nodesSeen.contains(head)) {
				return true;
			} else {
				nodesSeen.add(head);
			}
			head = head.next;
		}
		return false;
	}
}
