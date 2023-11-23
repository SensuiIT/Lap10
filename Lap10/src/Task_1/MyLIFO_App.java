package Task_1;

import java.util.Stack;

import javax.management.openmbean.OpenMBeanAttributeInfo;

public class MyLIFO_App {

	// This method reserves the given array
	public static <E> void reserve(E[] array) {
	// TODO
		Stack<E> stack = new Stack<E>();
		for(E ele : array) {
			stack.push(ele);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = stack.pop();
		}
	}
	// This method checks the correctness of the given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==> false
	public static boolean isCorrect(String input) {
	// TODO
		Stack<Character> stack = new Stack<>();
		
		for(char kt : input.toCharArray()) {
			if(kt=='('||kt=='{'||kt=='[') {
				stack.push(kt);
			}else if(kt==')' && !stack.isEmpty() && stack.peek()=='(') {
				stack.pop();
			}else if(kt=='}' && !stack.isEmpty() && stack.peek()=='{') {
				stack.pop();
			}else if(kt==']' && !stack.isEmpty() && stack.peek()=='[') {
				stack.pop();
			}else if(kt==')' || kt=='}' || kt==']'){
				return false;
			}
		}
	return stack.isEmpty();
	}
	// This method evaluates the value of an expression
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
	// TODO
		  Stack<Integer> operandStack = new Stack<>();
	        Stack<Character> operatorStack = new Stack<>();

	        for (int i = 0; i < expression.length(); i++) {
	            char current = expression.charAt(i);

	            if (Character.isDigit(current)) {
	                // Nếu ký tự là chữ số thì trích xuất toàn bộ số
	                StringBuilder num = new StringBuilder();
	                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
	                    num.append(expression.charAt(i));
	                    i++;
	                }
	                i--; // Lùi lại một bước để tính phần tăng thêm trong vòng lặp
	                operandStack.push(Integer.parseInt(num.toString()));
	            } else if (current == '(') {
	                operatorStack.push(current);
	            } else if (current == ')') {
	                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
	                    performOperation(operandStack, operatorStack);
	                }
	                operatorStack.pop(); // Pop '('
	            } else if (isOperator(current)) {
	                while (!operatorStack.isEmpty() && precedence(current) <= precedence(operatorStack.peek())) {
	                    performOperation(operandStack, operatorStack);
	                }
	                operatorStack.push(current);
	            }
	        }

	        while (!operatorStack.isEmpty()) {
	            performOperation(operandStack, operatorStack);
	        }

	        return operandStack.pop();
	    }
    private static int precedence(char operator) {
		// TODO Auto-generated method stub
		switch (operator) {
		case '+':
		case'-':
			return 1;
		case '*':
		case'/':
			return 2;
		default:
			return 0;
		}
	}
	private static boolean isOperator(char ch) {
		// TODO Auto-generated method stub
		return ch == '+'|| ch == '-'|| ch == '*'|| ch == '/';
	}
	private static void performOperation(Stack<Integer> openradStack, Stack<Character> openratorStack) {
		// TODO Auto-generated method stub
		int a = openradStack.pop();
		int b = openradStack.pop();
		char ch = openratorStack.pop();
		
		switch(ch){
		case '+':
			openradStack.push(a+b);
			break;
		case '-':
			openradStack.push(a-b);
			break;
		case '*':
			openradStack.push(a*b);
			break;
		case '/':
			openradStack.push(a/b);
			break;
		}
	}
	public static void main(String[] args) {
        String test = "()(())[]{(())}";
        System.out.println(isCorrect(test));
        String test2 = "51 + (54 *(3+2))";
        System.out.println(evaluateExpression(test2));
    }
}
