/**
 * Program to test a list if it is sorted
 * 
 * @author Lan Chang
 * @date 2/25/2016
 */

import java.util.Scanner;

public class Exercise7_19 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int repeatInt = 1;
		System.out.println("This program is to test a list if it is sorted.");
		
		while(repeatInt == 1) {
			
			// input
			System.out.print("Enter a number as the number of the list and then enter the list: ");
			int n = input.nextInt();
			int[] number = new int[n];		
			for (int i = 0; i < number.length; i++) {
				number[i] = input.nextInt();
			}
			
			boolean flag = isSorted(number);     // check if it is sorted
			
			// output
			if(flag) {
				System.out.println("The list is already sorted.");
			}
			else {
				System.out.println("The list is not sorted.");
			}
			
			System.out.print("Repeat program(1 for yes or 0 for no)?: ");
			repeatInt = input.nextInt();
		}
		
		System.out.println("Thank you for testing.");
	}
	
	public static boolean isSorted(int[] list) {
		
		// compare every neighboring two numbers, if the forward one is bigger than the back one, the list is not sorted
		for (int i = 0; i < list.length - 1; i++) {
			if (list[i] > list[i + 1]) {
				return false;
			}
		}
		return true;
	}
}