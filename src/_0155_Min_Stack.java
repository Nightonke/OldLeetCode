
public class _0155_Min_Stack {

/*	Design a stack that supports push, pop, top, and retrieving the minimum 
 *  element in constant time.

	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	getMin() -- Retrieve the minimum element in the stack.*/
	
	class MinStack {
	public:
	    void push(int x) {
	        if (s.empty()) {
	            s.push(0);
	            si.push(false);
	            m = x;
	        } else {
	            long temp = x - m;
	            if (temp < INT_MIN) s.push(temp - INT_MIN), si.push(true);
	            else if (temp > INT_MAX) s.push(temp - INT_MAX), si.push(true);
	            else s.push(temp), si.push(false);
	            if (x < m) m = x;
	        }
	    }
	    void pop() {
	        if (s.empty()) return;
	        long temp = s.top();
	        if (temp < 0) {
	            if (si.top()) temp -= INT_MIN;
	            m = m - temp;
	        }
	        s.pop();
	        si.pop();
	    }
	    int top() {
	        long temp = s.top();
	        if (temp > 0)
	            if (si.top()) return temp + m + INT_MAX;
	            else return temp + m;
	        else return m;
	    }
	    int getMin() {
	        return m;
	    }
	    stack<int> s;
	    stack<bool> si;
	    long m;
	};
	
}
