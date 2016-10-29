/**
 * Program to make a decision if the point is in the rectangle
 * 
 * @author Lan Chang
 * @date 2/10/2016
 */

import java.util.Scanner;

public class Exercise3_23 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int repeatInt = 1;
		System.out.println("This program is to make a decision if the point is in the rectangle.");		
		
		while(repeatInt == 1) {
			// input the rectangle's center coordinates
			System.out.print("Enter the rectangle's center with two coordinates: ");
			double p = input.nextDouble();
			double q = input.nextDouble();
		    
			// input the rectangle's width and height
			System.out.print("Enter the rectangle's width and height: ");
			double a = input.nextDouble();
			double b = input.nextDouble();
		    
			// input the point coordinates
		 	System.out.print("Enter the point with two coordinates: ");
		 	double x = input.nextDouble();
		 	double y = input.nextDouble();
		 	
		 	// calculate the horizontal distance to y-axis and vertical distance to x-axis
		 	double temp1 = x - p;
		 	double temp2 = y - q;
		 	double distance1 = Math.pow(temp1 * temp1, 0.5);   // transform into positive
			double distance2 = Math.pow(temp2 * temp2, 0.5);   // transform into positive
		    
			if (distance1 < a / 2 && distance2 < b / 2) {
				// if these distances match this condition, this point is inside the rectangle
				System.out.println("Point (" + x + ", " + y + ") is inside the rectangle");
			}
			else if (distance1 == a / 2 && distance2 <= b / 2 || distance1 <= a / 2 && distance2 == b / 2) {
				// if these distances match this condition, this point is on the boundary of the rectangle
				System.out.println("Point (" + x + ", " + y + ") is on the boundary of the rectangle");
			}
			else {
				// if these distances don't match the condition, this point is outside the rectangle
				System.out.println("Point (" + x + ", " + y + ") is outside the rectangle");
			}
		    
			System.out.print("Repeat program(1 for yes or 0 for no)?: ");
			repeatInt = input.nextInt();
		}
	}
}