package Task_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyFIFO_App {
	// method stutter that accepts a queue of integers a parameter and replaces
	// every element of the queue with two copies of that element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		Queue<E> queue = new LinkedList<E>();
		
		while(!input.isEmpty()) {
			queue.add(input.peek());
			queue.add(input.poll());			
		}
		input.addAll(queue);
	}
	// Method mirror that accepts a queue of strings as a parameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
	// TODO
		Queue<E> queue = new LinkedList<E>();
		Stack<E> stack = new Stack<E>();
		
		while(!input.isEmpty()) {
			queue.add(input.peek());
			stack.push(input.poll());
		}
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		input.addAll(queue);
	}
	public static void main(String[] args) {
		 Queue<Integer> t = new LinkedList<>();
	        t.add(1); 
	        t.add(2);
	        t.add(3);
	        stutter(t);
	        System.out.println(t);
	        mirror(t);
	        System.out.println(t);
	    }
	}