import java.util.LinkedList;
import java.util.Queue;

/*Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, 
peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. 
You may simulate a queue by using a list or deque (double-ended queue), 
as long as you use only standard operations of a queue.
You may assume that all operations are valid 
(for example, no pop or top operations will be called on an empty stack).*/
public class _225_ImplementStackusingQueues {
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.pop();
		System.out.println(myStack.top());
		System.out.println(myStack.empty());

	}

}

class MyStack {
	private Queue<Integer> q1 = new LinkedList<>();
	private Queue<Integer> q2 = new LinkedList<>();
	private int top;

	// Return whether the stack is empty.
	public boolean empty() {
		return q1.isEmpty();

	}

	// Removes the element on top of the stack.
	public void pop() {
		while (q1.size() > 1) {
			top = q1.remove();
			q2.add(top);
		}
		q1.remove();
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}

	// Push element x onto stack.
	public void push(int x) {
		q1.add(x);
		top = x;
	}

	// Get the top element.
	public int top() {
		return top;
	}
}