/**
 * Program to calculate the great circle distance between two points on the surface of a sphere
 * 
 * @author Lan Chang
 * @date 2/10/2016
 */

import java.util.Scanner;

public class Exercise4_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int repeatInt = 1;
		double r = 6371.01;
		System.out.println("This program is to calculate the great circle distance between two points on the surface of a sphere.");
		
		while(repeatInt == 1) {
			// input point 1 latitude and longitude
			System.out.print("Enter point 1 (latitude and longitude) in degrees: ");
			double x1 = input.nextDouble();
			double y1 = input.nextDouble();
			double a1 = Math.toRadians(x1);   // transform into radian
			double b1 = Math.toRadians(y1);   // transform into radian
		    
			// input point 2 latitude and longitude
			System.out.print("Enter point 2 (latitude and longitude) in degrees: ");
			double x2 = input.nextDouble();
			double y2 = input.nextDouble();
			double a2 = Math.toRadians(x2);   // transform into radian
			double b2 = Math.toRadians(y2);   // transform into radian
		 	
			// calculate the great circle distance
			double d = r * Math.acos(Math.sin(a1) * Math.sin(a2) + Math.cos(a1) * Math.cos(a2) * Math.cos(b1 - b2));
			System.out.println("The distance between the two points is " + d + " km");
		    
			System.out.print("Repeat program(1 for yes or 0 for no)?: ");
			repeatInt = input.nextInt();
		}
	}
}