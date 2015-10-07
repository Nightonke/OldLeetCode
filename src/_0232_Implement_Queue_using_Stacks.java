
public class _0232_Implement_Queue_using_Stacks {

/*	Implement the following operations of a queue using stacks.

	push(x) -- Push element x to the back of queue.
	pop() -- Removes the element from in front of queue.
	peek() -- Get the front element.
	empty() -- Return whether the queue is empty.
	Notes:
	You must use only standard operations of a stack -- which means only push 
	to top, peek/pop from top, size, and is empty operations are valid.
	Depending on your language, stack may not be supported natively. You may 
	simulate a stack by using a list or deque (double-ended queue), as long as 
	you use only standard operations of a stack.
	You may assume that all operations are valid (for example, no pop or peek 
	operations will be called on an empty queue).*/
	
	class Queue {
	public:
	    stack<int> s;
	    // Push element x to the back of queue.
	    void push(int x) {
	        stack<int> temp;
	        while (!s.empty()) {
	            temp.push(s.top());
	            s.pop();
	        }
	        s.push(x);
	        while (!temp.empty()) {
	            s.push(temp.top());
	            temp.pop();
	        }
	    }

	    // Removes the element from in front of queue.
	    void pop(void) {
	        s.pop();
	    }

	    // Get the front element.
	    int peek(void) {
	        return s.top();
	    }

	    // Return whether the queue is empty.
	    bool empty(void) {
	        return s.empty();
	    }
	};
	
}
