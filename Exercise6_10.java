/**
 * Program to show the first 50 prime numbers,
 * and check if a number is a prime number,
 * and if not, show its prime factors
 * 
 * @author Lan Chang
 * @date 2/23/2016
 */

import java.util.Scanner;

public class Exercise6_10 {
	public static void main(String[] args) {
		System.out.println("This program is to show the first 50 prime numbers, and check if a number is a prime number, and if not, show its prime factors.");
		
		int n = 1000;
		int[] numberList = new int[n];   // array to store the first 1000 prime numbers
		primeNumbers(n, numberList);     // find the first 1000 prime numbers
		int m = 50;
		printNumbers(m, numberList);     // show the first 50 prime numbers
		checkNumbers(n, numberList);     // check if a number is a prime number
	}

	public static void primeNumbers(int n, int[] numberList) {
		int count = 0;     // count the number of prime numbers
		int number = 2;     // a number to be check
		while (count < n) {
			if(isPrime(number)) {
				numberList[count] = number;     // array to store the prime number
				count++;
			}
			number++;
		}
	}
	
	public static boolean isPrime(int number) {
		for (int divisor = 2; divisor <= number / 2; divisor++) {
			if (number % divisor == 0) {     // if the remainder is 0, the "number" is not a prime number
				return false;
			}
		}
		return true;
	}
	
	public static void printNumbers(int m, int[] numberList) {
		System.out.println("The first 50 prime numbers are: ");
		final int NUMBER_OF_PRIMES_PER_LINE = 10;
		for (int i = 0; i < m; i++) {
			if((i + 1) % NUMBER_OF_PRIMES_PER_LINE == 0) {
				System.out.printf("%-5s\n", numberList[i]);
			}
			else {
				System.out.printf("%-5s", numberList[i]);
			}
		}
	}
	
	public static void checkNumbers(int n, int[] numberList) {
		Scanner input = new Scanner(System.in);
		int repeatInt = 1;
		while(repeatInt == 1) {
			int flag = 0;     // flag to sign if it's a prime number
			System.out.print("Enter an positive integer less than 1000: ");
			int number = input.nextInt();
			int temp = 1;     // flag to sign if it's a fit number
			while(temp == 1) {
				if (number < 1000 && number > 0) {
					temp = 0;
				}
				else {
					System.out.print("Error, please enter an positive integer less than 1000: ");
					number = input.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				if (number == numberList[i]) {     // check if the number is equal to any number in the array
					System.out.println(number + " is a prime number.");
					flag = 1;     // flag is 1, it's a prime number
				}
			}
			if (flag == 0 && number != 1) {
				System.out.print(number + " is a composite number, and its prime factors are:");
				showFactors(number);     // show the prime factors of this number
			}
			if (number == 1) {
				System.out.println(number + " is not a prime number or composite number.");
			}
			System.out.print("Repeat program(1 for yes or 0 for no)?: ");
			repeatInt = input.nextInt();
		}
		
		System.out.println("Thank you for testing.");
	}
	
	public static void showFactors(int number) {
		for(int factor = 2; factor <= number;) {
	    	if(number % factor == 0) {     // if the remainder is 0, the "factor" is a prime factor
	    		System.out.print(" " + factor);
	    		number = number / factor;     // find the remaining prime factors
	    	}
	    	else {
	    		factor++;
	    	}
	    }
		System.out.println("");
	}
}