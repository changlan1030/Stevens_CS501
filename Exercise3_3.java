/**
 * Program to solve 2 * 2 linear equations and
 * make a report if the linear equations have solution
 * 
 * @author Lan Chang
 * @date 2/10/2016
 */

import java.util.Scanner;

public class Exercise3_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int repeatInt = 1;
		System.out.println("This program is to solve 2*2 linear equations and make a report if the linear equations have solution.");
		System.out.println("ax + by = e");
		System.out.println("cx + dy = f");
		
		while(repeatInt == 1) {
			System.out.print("Enter a, b, c, d, e, f: ");
			double a = input.nextDouble();
			double b = input.nextDouble();
			double c = input.nextDouble();
			double d = input.nextDouble();
			double e = input.nextDouble();
			double f = input.nextDouble();
			
			double temp1 = a * d - b * c;   // calculate a * d - b * c which is the denominator
			double temp2 = e * d - b * f;   // calculate e * d - b * f which is the x's numerator
			double temp3 = a * f - e * c;   // calculate a * f - e * c which is the y's numerator
		    
			if (temp1 == 0) {
				// if the denominator is 0, there is no solution
				System.out.println("The equation has no solution");
			}
			else {
				// if the denominator is not 0, there is solution
				System.out.println("x is " + temp2 / temp1 + " and y is " + temp3 / temp1);
			}
		    
			System.out.print("Repeat program(1 for yes or 0 for no)?: ");
			repeatInt = input.nextInt();
		}
	}
}