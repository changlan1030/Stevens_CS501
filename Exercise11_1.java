/**
 * This program contains three parts:
 * 
 * A class named Triangle that extends GeometricObject. The class contains:
 * Three double data fields named side1, side2, and side3 with default values 1.0 to denote three sides of the triangle.
 * A no-arg constructor that creates a default triangle.
 * A constructor that creates a triangle with the specified side1, side2, and side3.
 * The accessor methods for all three data fields.
 * A method named getArea() that returns the area of this triangle.
 * A method named getPerimeter() that returns the perimeter of this triangle.
 * A method named toString() that returns a string description for the triangle.
 * 
 * A class named IllegalTriangleException that modify the constructor of the Triangle class
 * to throw an IllegalTriangleException object if a triangle is created with sides that violate the rule.
 * 
 * A test program that display the area, perimeter, color, and true or false to indicate whether it is filled or not.
 * 
 * @author Lan Chang
 * @date 4/8/2016
 */

import java.util.Scanner;

public class Exercise11_1 {
	public static void main(String[] args) {
		System.out.println("This program is to define a Triangle class and a IllegalTriangleException class,");
		System.out.println("to display the triangle area, perimeter, color, and whether it is filled or not,");
		System.out.println("to throw an exception if it is created with sides that violate the rule.");
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		int repeatInt = 1;
		
		while (repeatInt == 1) {
			System.out.print("Enter three sides£º ");
			double side1 = input.nextDouble();
			double side2 = input.nextDouble();
			double side3 = input.nextDouble();
			System.out.print("Enter the color£º ");
			String color = input.next();
			System.out.print("Enter if the triangle is filled(true or false)£º ");
			boolean filled = input.nextBoolean();
			
			if (side1 > 0 && side2 > 0 && side3 > 0) {
				try {
					Triangle triangle = new Triangle(side1, side2, side3);
					triangle.setColor(color);
					triangle.setFilled(filled);
				    
					System.out.println(triangle);
					System.out.println("Area: " + triangle.getArea());
					System.out.println("Perimeter: " + triangle.getPerimeter());
					System.out.println("Color: " + triangle.getColor());
					System.out.println("Filled: " + triangle.isFilled());
				}
				
				catch (IllegalTriangleException ex) {
					System.out.println("IllegalTriangleException: the sum of any two sides must be less than the third.");
				}
			}
			else {
				System.out.println("The side must be positive.");
			}

			System.out.print("Repeat program(1 for yes or 0 for no)?: ");
			repeatInt = input.nextInt();
		}
		System.out.println("Thank you for testing.");
	}
}

class IllegalTriangleException extends Exception {
	public IllegalTriangleException(String string) {
		super(string);
	}
}

class Triangle extends GeometricObject {
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle() throws IllegalTriangleException {
		this(1.0, 1.0, 1.0);
	}
	
	public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
		if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}
		else {
			throw new IllegalTriangleException("The sum of any two sides must be less than the third.");
		}
	}
	
	public double getSide1() {
		return side1;
	}
	
	public void setSide1(double side1) {
		this.side1 = side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public void setSide2(double side2) {
		this.side2 = side2;
	}
	
	public double getSide3() {
		return side3;
	}
	
	public void setSide3(double side3) {
		this.side3 = side3;
	}
	
	public double getArea() {
		double s = (side1 + side2 + side3) / 2;
		double area = Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
		return area;
	}
	
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	public String toString() {
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
}

abstract class GeometricObject {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;

	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}

	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	public String toString() {
		return "¡¤created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
	}

	public abstract double getArea();

	public abstract double getPerimeter();
}