/**
 * This program contains two parts:
 * 
 * A class named MyPoint that contains:
 * The data fields x and y that represent the coordinates with getter methods.
 * A no-arg constructor that creates a point (0, 0).
 * A constructor that constructs a point with specified coordinates.
 * A method named distance that returns the distance from this point to a specified point of the MyPoint type.
 * A method named distance that returns the distance from this point to another point with specified x- and y-coordinates.
 * 
 * A test program that creates the two points (0, 0) and (10, 30.5) and displays the distance between them.
 * 
 * @author Lan Chang
 * @date 4/1/2016
 */

public class Exercise10_4 {
	public static void main(String[] args) {
		System.out.println("This program is to define a MyPoint class and to display the distance between two specified points.");
		System.out.println();
		
		MyPoint point1 = new MyPoint();
		MyPoint point2 = new MyPoint(10, 30.5);
		
		System.out.println("The distance between these two points is:");
		System.out.println(point1.distance(point2));
		System.out.println(MyPoint.distance(point1, point2));
		
		System.out.println();
		System.out.println("Thank you for testing.");
	}
}

class MyPoint {
	private double x;
	private double y;
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public MyPoint() {
		this(0, 0);
	}
	
	public MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distance(MyPoint point) {
		return distance(this, point);
	}
	
	public static double distance(MyPoint point1, MyPoint point2) {
		return Math.sqrt((point1.x - point2.x) * (point1.x - point2.x) + (point1.y - point2.y) * (point1.y - point2.y));
	}
}