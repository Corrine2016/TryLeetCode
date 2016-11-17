import java.util.HashSet;
import java.util.Set;

/*Given a linked list, return the node where the cycle begins.
		If there is no cycle, return null.*/

//wenhui
public class _142_LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		Set<ListNode> nodesSeen = new HashSet<>();
		while (head != null) {
			if (nodesSeen.contains(head)) {
				return head;
			} else {
				nodesSeen.add(head);
			}
			head = head.next;
		}
		return null;
	}
}
