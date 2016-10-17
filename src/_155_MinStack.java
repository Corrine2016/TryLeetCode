/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.*/

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class _155_MinStack {

}

class MinStack {
	private class StackElement {
		public int val;
		public StackElement next;

		public StackElement(int val) {
			this.val = val;
			this.next = null;
		}
	}
	private StackElement top;

	private int minVal;

	/** initialize your data structure here. */
	public MinStack() {
		top = null;
		minVal = Integer.MAX_VALUE;
	}

	public int getMin() {
		return minVal;
	}

	public void plainPop() {
		if (top == null || top.next == null) {
			return;
		}
		top = top.next;
	}

	private void plainPush(int x) {
		if (top == null) {
			top = new StackElement(x);
		} else {
			StackElement newTop = new StackElement(x);
			newTop.next = top;
			top = newTop;
		}
	}

	public void pop() {
		// If the next element to pop is the minimum element, we need to
		// reassign the minimum value to the value of the element right
		// below the currently popped element, and pop that new min as well
		// to avoid duplicate.
		if (top.val == minVal) {
			this.plainPop(); // Pop the minimum element
			minVal = this.top(); // Second minimum element value
			this.plainPop(); // Pop the second minimum element
		} else {
			this.plainPop(); // Just pop it. No need to update minimum value.
		}
	}

	public void push(int x) {
		if (x <= minVal) {
			// x is minimum. This means 'min' is now second minimum. Push it on
			// stack.
			// Update min. This way, the next time we pop the minimum value, we
			// know
			// the second minimum value is right below the one we poped. Then we
			// can just
			// pop that second minimum value and update 'min' (Because we pushed
			// the second
			// minimum value to the stack twice).
			this.plainPush(minVal);
			minVal = x;
		}
		// Push this element to the stack always.
		this.plainPush(x);
	}

	public int top() {
		return top.val;
	}
}
