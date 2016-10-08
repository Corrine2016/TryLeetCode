/*Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 �� a2
                   �K
                     c1 �� c2 �� c3
                   �J            
B:     b1 �� b2 �� b3
begin to intersect at node c1.
Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.*/

public class _160_IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int lenA = listLength(headA);
		int lenB = listLength(headB);
		int diff = 0;
		if (lenA > lenB) {
			diff = lenA - lenB;
			while (diff-- > 0) {
				headA = headA.next;
			}
		} else {
			diff = lenB - lenA;
			while (diff-- > 0) {
				headB = headB.next;
			}
		}
		while (headA != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	private int listLength(ListNode head) {
		int res = 0;
		ListNode tempHead = head;
		while (tempHead != null) {
			tempHead = tempHead.next;
			res++;
		}
		return res;
	}
}
