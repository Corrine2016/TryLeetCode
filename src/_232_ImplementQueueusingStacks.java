import java.util.Stack;

/*Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, 
peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. 
You may simulate a stack by using a list or deque (double-ended queue), 
as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek
		operations will be called on an empty queue).*/
public class _232_ImplementQueueusingStacks {
	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		myQueue.push(1);

		myQueue.pop();
		System.out.println(myQueue.peek());
		System.out.println(myQueue.empty());
	}

}

class MyQueue {
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	int front;

	// Return whether the queue is empty.
	public boolean empty() {
		return s1.isEmpty();
	}

	// Get the front element.
	public int peek() {

		return front;
	}

	// Removes the element from in front of queue.
	public void pop() {
		s1.pop();
		if (!s1.empty())
			front = s1.peek();
	}

	// Push element x to the back of queue.
	public void push(int x) {
		if (s1.empty())
			front = x;
		while (!s1.isEmpty())
			s2.push(s1.pop());
		s2.push(x);
		while (!s2.isEmpty())
			s1.push(s2.pop());
	}
}