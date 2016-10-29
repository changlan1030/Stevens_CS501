/**
 * This program is to display all the prime numbers less than 120 in decreasing order using the StackOfIntegers class
 * 
 * @author Lan Chang
 * @date 4/1/2016
 */

public class Exercise10_6 {
	public static void main(String[] args) {
		System.out.println("This program is to display all the prime numbers less than 120 in decreasing order using the StackOfIntegers class.");
		System.out.println();
		
		StackOfIntegers stack = new StackOfIntegers();
		int limit = 120;
		int number = 2;
		
		while (number < limit) {
			if(isPrime(number)) {
				stack.push(number);
			}
			number++;
		}
		
		int index = 1;
		System.out.println("The prime numbers less than 120 are:");
		while (!stack.empty()) {
			System.out.print(stack.pop() + " ");
			if (index % 10 == 0) {
				System.out.println();
			}
			index++;
		}
		
		System.out.println();
		System.out.println("Thank you for testing.");
	}
	
	public static boolean isPrime(int number) {
		for (int divisor = 2; divisor <= number / 2; divisor++) {
			if (number % divisor == 0) {
				return false;
			}
		}
		return true;
	}
}

class StackOfIntegers {
	private int[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY = 16;

	public StackOfIntegers() {
		this(DEFAULT_CAPACITY);
	}
	
	public StackOfIntegers(int capacity) {
		elements = new int[capacity];
	}

	public void push(int value) {
		if (size >= elements.length) {
			int[] temp = new int[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
		elements[size++] = value;
	}

	public int pop() {
		return elements[--size];
	}
	
	public int peek() {
		return elements[size - 1];
	}

	public boolean empty() {
		return size == 0;
	}
	
	public int getSize() {
		return size;
	}
}