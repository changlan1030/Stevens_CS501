/**
 * Program to find the smallest element in a list and its index
 * 
 * @author Lan Chang
 * @date 2/25/2016
 */

import java.util.Scanner;

public class Exercise7_10 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int repeatInt = 1;
		System.out.println("This program is to find the smallest element in a list and its index.");
		
		while(repeatInt == 1) {
			int n = 10;
			double[] number = new double[n];
			
			// input
			System.out.print("Enter ten numbers: ");
			for (int i = 0; i < number.length; i++) {
				number[i] = input.nextDouble();
			}
			
			double minNum = min(number);     // find the smallest number
			int index = indexOfSmallestElement(number);     // find its index
			
			// output
			System.out.println("The smallest number is: " + minNum);
			System.out.println("and its index is: " + index);
			
			System.out.print("Repeat program(1 for yes or 0 for no)?: ");
			repeatInt = input.nextInt();
		}
		
		System.out.println("Thank you for testing.");
	}
	
	public static double min(double[] array) {
		double min = array[0];     // assume the smallest number is the first one
		
		// compare each number with the smallest number, if this number smaller than the minimum, it will be the smallest one
		for (int i = 1; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}
	
	public static int indexOfSmallestElement(double[] array) {
		int index = 0;
		double min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
				index = i;
			}
		}
		return index;
	}
}