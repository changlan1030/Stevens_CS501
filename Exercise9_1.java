/**
 * Program to use a Rectangle class to calculate the area and perimeter
 * 
 * @author Lan Chang
 * @date 3/9/2016
 */

import java.util.Scanner;

public class Exercise9_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int repeatInt = 1;
		System.out.println("This program is to use a Rectangle class to calculate the area and perimeter.");
		
		while(repeatInt == 1) {
			try {
				System.out.print("Enter the width and height: ");
				double width = input.nextDouble();
				double height = input.nextDouble();
				
				Rectangle myRectangle = new Rectangle(width, height);
				
				System.out.println("Width = " + myRectangle.width + ", Height = " + myRectangle.height);
				System.out.println("Area = " + myRectangle.getArea() + ", Perimeter = " + myRectangle.getPerimeter());
			}
			catch (IllegalArgumentException ex) {
				System.out.println("Exception: the width and height must be positive.");
			}
			
			System.out.print("Repeat program(1 for yes or 0 for no)?: ");
			repeatInt = input.nextInt();
		}
		System.out.println("Thank you for testing.");
	}
}

class Rectangle {
	double width;
	double height;
	
	public Rectangle () {
	}
	
	public Rectangle (double newWidth, double newHeight) {
		setNew(newWidth, newHeight);
	}
	
	public void setNew(double newWidth, double newHeight) throws IllegalArgumentException {
		if (newWidth > 0 && newHeight > 0) {
			width = newWidth;
			height = newHeight;
		}
		else {
			throw new IllegalArgumentException("The width and height must be positive.");
		}
	}
	
	public double getArea() {
		double area = width * height;
		return area;
	}
	
	public double getPerimeter() {
		double perimeter = (width + height) * 2;
		return perimeter;
	}
}