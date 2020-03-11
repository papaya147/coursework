
/*
This program converts an arithmetic expression to a postfix expression
There are 4 methods: main, operators, equalsoperator, heirarchy

main()
	gets the infix input from the user
	makes an operator array with elements: ^, /, *, +, -, (, )
	makes a priority array with elements: 2, 1, 1, 0, 0, -1, -1, which corresponds to the operator array
	makes an equation array which is the equation in a character array
	creates a stack with a number of operators as spaces
		number of operators is found by operators() method
	loops through the whole equation with a for loop
		if the character is an operator
			checks using isOperator() method
			if the stack is empty, the operator is pushed onto the stack
			else if the operator is "(" the ( is pushed onto the stack
			else the stack is looped through
				if the top of the stack is a "(" and the character is ")"
					the stack is popped
				else if the heirarchy of the top of the stack is greater than the operator and if the top of the stack is not "("
					add the operator to the postfix string
					pop the stack
		else add the character to the postfix
	loop through the stack
		if the character is "(" the stack is popped
		else add the operator to the postfix string

operators()
	loops through both the operator array and equation array and return the number of operations

equalsOperator():
	loops through the operator array and checks if the character is an operator

heirarchy():
	loops through the operator array to find the priorty of the top-of-the-stack's character
    returns the priorty of the stacks top element - the current operator
 */
import java.util.Scanner;

public class PostFix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter infix: ");
		String infix = sc.nextLine().trim();

		char oper[] = { '^', '/', '*', '+', '-', '(', ')' };
		int prior[] = { 2, 1, 1, 0, 0, -1, -1 };
		char eq[] = infix.toCharArray();

		Stack s = new Stack(operators(oper, eq));
		String postfix = "";

		outer: for (int x = 0; x < infix.length(); x++) {
			if (equalsOperator(eq[x], oper)) {
				if (s.isEmpty()) {
					s.push(Character.toString(eq[x]));
				} else if (eq[x] == '(') {
					s.push(Character.toString(eq[x]));
				} else {
					for (int y = 0; y <= s.length; y++) {
						if (s.peek().equals("(") && eq[x] == ')') {
							s.pop();
							continue outer;
						} else if (heirarchy(s.peek(), prior, eq[x], oper) >= 0 && !s.peek().equals("(")) {
							postfix += s.peek();
							s.pop();
						}
					}
					s.push(Character.toString(eq[x]));
				}
			} else {
				postfix += Character.toString(eq[x]);
			}
		}

		for (int x = 0; x <= s.stack.length; x++) {
			try {
				if (s.peek().equals("(") || s.peek().equals(")")) {
					s.pop();
				} else {
					postfix += s.peek();
					s.pop();
				}
			} catch (Exception e) {
				break;
			}
		}

		System.out.println(postfix);
		sc.close();
	}

	public static int operators(char oper[], char eq[]) {
		int no_ops = 0;

		for (int x = 0; x < eq.length; x++) {
			for (int y = 0; y < oper.length; y++) {
				if (eq[x] == oper[y]) {
					no_ops++;
				}
			}
		}

		return no_ops;
	}

	public static boolean equalsOperator(char eq, char oper[]) {
		boolean flag = false;
		for (int x = 0; x < oper.length; x++) {
			if (oper[x] == eq) {
				flag = true;
			}
		}
		return flag;
	}

	public static int heirarchy(String prev, int prior[], char now, char oper[]) {
		int prevheir = 0, nowheir = 0;
		for (int x = 0; x < oper.length; x++) {
			if (Character.toString(oper[x]).equals(prev)) {
				prevheir = prior[x];
			}
		}
		for (int x = 0; x < oper.length; x++) {
			if (oper[x] == now) {
				nowheir = prior[x];
			}
		}
		return prevheir - nowheir;
	}
}