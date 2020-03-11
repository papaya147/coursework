/*
There are four operations in this class, they are:
     push
     pop
     peek
     display
     
push(): 
	a number n is passed
    if the stack is full, "stack overflow" is shown
    else the number n is added to the stack
    the top element index is incremented, the length is incremented
         
pop():
	if the stack is empty, "stack underflow" is shown
    else the top element is deleted
    the top index is decremented
    the length is decremented
        
peek():
	if the stack is empty, "no element" is shown
    else the top element is displayed
         
display(): 
	prints the full stack using a loop
 */
public class Stack {
	int top;
	int length;
	int size;
	String[] stack;

	public Stack(int n) {
		stack = new String[n];
		top = -1;
		length = 0;
		size = n;
	}

	public void push(String n) {
		if (isFull()) {
			System.err.println("Stack Overflow");
		} else {
			stack[++top] = n;
			length++;
		}
	}

	public void pop() {
		if (isEmpty()) {
			System.err.println("Stack Underflow");
		} else {
			stack[top--] = "";
			length--;
		}
	}

	public boolean isFull() {
		return size == length;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public String peek() {
		if (top < 0) {
			System.err.println("No element");
		}
		return stack[top];
	}

	public void display() {
		for (int x = 0; x < size; x++) {
			System.out.println(stack[x]);
		}
	}
}
