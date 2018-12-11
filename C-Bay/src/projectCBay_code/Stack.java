package projectCBay_code;

import java.util.EmptyStackException;

public class Stack<E> {
	
	private Object[] stack;
	private int count;
	
	
	public Stack() {
		final int INITIAL_CAPACITY = 10;
		count = 0;
		stack = new Object[INITIAL_CAPACITY];
	}
	

	public void ensureCapacity(int minimumCapacity) {
		Object[]biggerArray;
		if(stack.length < minimumCapacity) {
			biggerArray = new Object[minimumCapacity];
			System.arraycopy(stack, 0, biggerArray, 0, count);
			stack = biggerArray;
		}
	}
	

	public void push(E element) {
		if(count == stack.length) {
			ensureCapacity(count*2+1);
		}
		stack[count] = element;
		count++;
	}
	
	
	public E pop() {
		E answer = null;
		if (isEmpty()) {
		}
		else {
		answer = (E) stack[count - 1];
		}
		count--;
		return answer;	
	}
	
	
	public E peek() {
		E element = null;
		if (isEmpty()) {
		}
		else{
			element = (E) stack[count - 1];
		}
		return element;
	}
	
	
	public boolean isEmpty() {
		return count == 0;
	}
}
