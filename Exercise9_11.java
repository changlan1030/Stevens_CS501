/**
 * Program to use a LinearEquation class to find the intersecting point of two lines
 * 
 * @author Lan Chang
 * @date 3/10/2016
 */

import java.util.Scanner;

public class Exercise9_11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int repeatInt = 1;
		System.out.println("This program is to use a LinearEquation class to find the intersecting point of two lines.");
		
		while(repeatInt == 1) {
			
			// input four endpoints
			System.out.print("Enter the endpoint 1 of line 1: ");
			double x1 = input.nextDouble();
			double y1 = input.nextDouble();
			System.out.print("Enter the endpoint 2 of line 1: ");
			double x2 = input.nextDouble();
			double y2 = input.nextDouble();
			System.out.print("Enter the endpoint 1 of line 2: ");
			double x3 = input.nextDouble();
			double y3 = input.nextDouble();
			System.out.print("Enter the endpoint 2 of line 2: ");
			double x4 = input.nextDouble();
			double y4 = input.nextDouble();
			
			// calculate a, b, c, d, e and f
			double a = y1 - y2;
			double b = x2 - x1;
			double c = y3 - y4;
			double d = x4 - x3;
			double e = (y1 - y2) * x1 - (x1 - x2) * y1;
			double f = (y3 - y4) * x3 - (x3 - x4) * y3;
			
			// call the class
			LinearEquation equation = new LinearEquation(a, b, c, d, e, f);
			
			// output
			if (equation.isSolvable()) {
				System.out.println("The two lines are crossing lines, and the intersecting point is (" + equation.getX() + ", " + equation.getY() + ").");
			}
			else if ((a == 0 && b == 0) || (c == 0 && d == 0)) {
				System.out.println("Error. You enter the same endpoint for one line.");
			}
			else if ((a * d == b * c) && (b * f == d * e)) {
				System.out.println("The two lines are coincidence lines.");
			}
			else {
				System.out.println("The two lines are parallel lines.");
			}
		    
			System.out.print("Repeat program(1 for yes or 0 for no)?: ");
			repeatInt = input.nextInt();
		}
		System.out.println("Thank you for testing.");
	}
}

class LinearEquation {
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	
	public LinearEquation(double equation_a, double equation_b, double equation_c, double equation_d, double equation_e, double equation_f) {
		a = equation_a;
		b = equation_b;
		c = equation_c; 
		d = equation_d;
		e = equation_e;
		f = equation_f; 
	}
	
	double getA() {
		return a;
	}

	double getB() {
		return b;
	}

	double getC() {
		return c;
	}

	double getD() {
		return d;
	}
	
	double getE() {
		return e;
	}
	
	double getF() {
		return f;
	}
	
	boolean isSolvable() {
		if (a * d - b * c != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	double getX() {
		double x = (e * d - b * f) / (a * d - b * c);
		return x; 
	}

	double getY() {
		double y = (a * f - e * c) / (a * d - b * c);
		return y;
	}
}