/**
 * Program to displays the first 100 palindromic prime numbers
 * 
 * @author Lan Chang
 * @date 3/16/2016
 */

public class Exercise6_26 {
	public static void main(String[] args) {
		System.out.println("This program is to displays the first 100 palindromic prime numbers.");

		int index = 1;
		int number = 2;
		
		while (index <= 100) {
			if (isPrime(number) && isPalindromic(number)){
				if (index % 10 != 0) {
					System.out.print(number + " ");
				}
				else {
					System.out.println(number);
				}
				index++;
			}
			number++;
		}
	}
	
	public static boolean isPrime(int number) {
		for (int divisor = 2; divisor <= number / 2; divisor++) {
			if (number % divisor == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindromic(int number) {
		String numberStr = number + "";
		int l_numberStr = numberStr.length();
		for (int i = 0; i != l_numberStr; i++) {
			if (numberStr.charAt(i) != numberStr.charAt(l_numberStr - i - 1)) {
				return false;
			}
		}
		return true;
	}
}