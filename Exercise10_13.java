/**
 * This program contains two parts:
 * 
 * A class named MyRectangle2D that contains:
 * Two double data fields named x and y that specify the center of the rectangle with getter and setter methods.
 * The data fields width and height with getter and setter methods.
 * A no-arg constructor that creates a default rectangle with (0, 0) for (x, y) and 1 for both width and height.
 * A constructor that creates a rectangle with the specified x, y, width, and height.
 * A method getArea() that returns the area of the rectangle.
 * A method getPerimeter() that returns the perimeter of the rectangle.
 * A method contains(double x, double y) that returns true if the specified point (x, y) is inside this rectangle.
 * A method boundaries(double x, double y) that returns true if the specified point (x, y) is on the boundary.
 * A method distincts(double x, double y) that returns true if the specified point (x, y) is outside this rectangle.
 * A method contains(MyRectangle2D r) that returns true if the specified rectangle is inside this rectangle.
 * A method equals(MyRectangle2D r) that returns true if the specified rectangle is equal to this rectangle.
 * A method overlaps(MyRectangle2D r) that returns true if the specified rectangle overlaps with this rectangle.
 * A method abuts(MyRectangle2D r) that returns true if the specified rectangle abuts this rectangle.
 * A method distincts(MyRectangle2D r) that returns true if the specified rectangle is outside this rectangle.
 * 
 * A test program that create a basic rectangle and check the position of a new point or rectangle with this rectangle.
 * 
 * @author Lan Chang
 * @date 4/8/2016
 */

import java.util.Scanner;

public class Exercise10_13 {
	public static void main(String[] args) {
		System.out.println("This program is to define a MyRectangle2D class and compare a point or a rectangle with a specified rectangle.");
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		int repeatInt_1 = 1;
		
		while (repeatInt_1 == 1) {
			System.out.print("Enter the specified rectangle(center point, width and height): ");
			double basic_x = input.nextDouble();
			double basic_y = input.nextDouble();
			double basic_width = input.nextDouble();
			double basic_height = input.nextDouble();
			
			if (basic_width <= 0 || basic_height <= 0) {
				System.out.println("The width and height must be positive.");
			}
			else {
				MyRectangle2D r1 = new MyRectangle2D(basic_x, basic_y, basic_width, basic_height);
				System.out.println("Area: " + r1.getArea());
				System.out.println("Perimeter: " + r1.getPerimeter());
				
				int repeatInt_2 = 1;
				
				while (repeatInt_2 == 1) {
					System.out.print("Test point or rectangle(1 for point or 2 for rectangle)?: ");
					int choiceInt = input.nextInt();
					
					if (choiceInt == 1) {
						System.out.print("Enter the test point: ");
						double point_x = input.nextDouble();
						double point_y = input.nextDouble();
						
						if (r1.contains(point_x, point_y)) {
							System.out.println("The point is inside the rectangle.");
						}
						if (r1.boundaries(point_x, point_y)) {
							System.out.println("The Point is on the boundary.");
						}
						if (r1.distincts(point_x, point_y)) {
							System.out.println("The Point is outside the rectangle.");
						}
					}
					else if (choiceInt == 2) {
						System.out.print("Enter the test rectangle(center point, width and height): ");
						double test_x = input.nextDouble();
						double test_y = input.nextDouble();
						double test_width = input.nextDouble();
						double test_height = input.nextDouble();
						
						if (test_width <= 0 || test_height <= 0) {
							System.out.println("The width and height must be positive.");
						}
						else {
							MyRectangle2D r2 = new MyRectangle2D(test_x, test_y, test_width, test_height);
							
							if (r1.contains(r2)) {
								if (r1.equals(r2)) {
									System.out.println("A rectangle is equal to another rectangle.");
								}
								else {
									System.out.println("A rectangle is inside another rectangle.");
								}
							}
							else if (r1.overlaps(r2)) {
								if (r1.abuts(r2)) {
									System.out.println("A rectangle abuts another rectangle.");
								}
								else {
									System.out.println("A rectangle overlaps another rectangle.");
								}
							}
							else if (r1.distincts(r2)) {
								System.out.println("A rectangle is outside another rectangle.");
							}
						}
					}
					else {
						System.out.println("Wrong choice.");
					}
					
					System.out.print("New test for this specified rectangle(1 for yes or 0 for no)?: ");
					repeatInt_2 = input.nextInt();
				}
			}

			System.out.print("New specified rectangle(1 for yes or 0 for no)?: ");
			repeatInt_1 = input.nextInt();
		}
		System.out.println("Thank you for testing.");
	}
}

class MyRectangle2D {
	private double x;
	private double y;
	private double width;
	private double height;
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public MyRectangle2D() {
		this(0, 0, 1, 1);
	}
	
	public MyRectangle2D(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public double getArea() {
		return width * height;
	}
	
	public double getPerimeter() {
		return 2 * (width + height);
	}
	
	public boolean contains(double x, double y) {
		double deltaX = Math.abs(this.x - x);
		double deltaY = Math.abs(this.y - y);
		if (deltaX < width / 2 && deltaY < height / 2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean boundaries(double x, double y) {
		double deltaX = Math.abs(this.x - x);
		double deltaY = Math.abs(this.y - y);
		if (deltaX == width / 2 && deltaY <= height / 2 || deltaX <= width / 2 && deltaY == height / 2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean distincts(double x, double y) {
		double deltaX = Math.abs(this.x - x);
		double deltaY = Math.abs(this.y - y);
		if (deltaX > width / 2 || deltaY > height / 2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean equals(MyRectangle2D r) {
		if (r.x == this.x && r.y == this.y && r.width == this.width && r.height == this.height) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean contains(MyRectangle2D r) {
		double r_x1 = r.x - r.width / 2;
		double r_x2 = r.x + r.width / 2;
		double r_y1 = r.y - r.height / 2;
		double r_y2 = r.y + r.height / 2;
		
		double this_x1 = this.x - this.width / 2;
		double this_x2 = this.x + this.width / 2;
		double this_y1 = this.y - this.height / 2;
		double this_y2 = this.y + this.height / 2;
		
		if ((r.contains(this_x1, this_y1) || r.boundaries(this_x1, this_y1)) &&
				(r.contains(this_x2, this_y1) || r.boundaries(this_x2, this_y1)) &&
				(r.contains(this_x1, this_y2) || r.boundaries(this_x1, this_y2)) &&
				(r.contains(this_x2, this_y2) || r.boundaries(this_x2, this_y2)) ||
				(this.contains(r_x1, r_y1) || this.boundaries(r_x1, r_y1)) &&
				(this.contains(r_x2, r_y1) || this.boundaries(r_x2, r_y1)) &&
				(this.contains(r_x1, r_y2) || this.boundaries(r_x1, r_y2)) &&
				(this.contains(r_x2, r_y2) || this.boundaries(r_x2, r_y2))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean overlaps(MyRectangle2D r) {
		double deltaX = Math.abs(this.x - r.x);
		double deltaY = Math.abs(this.y - r.y);
		double deltaWidth = (this.width + r.width) / 2;
		double deltaHeight = (this.height + r.height) / 2;
		
		if (deltaX <= deltaWidth && deltaY <= deltaHeight) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean abuts(MyRectangle2D r) {
		double deltaX = Math.abs(this.x - r.x);
		double deltaY = Math.abs(this.y - r.y);
		double deltaWidth = (this.width + r.width) / 2;
		double deltaHeight = (this.height + r.height) / 2;
		
		if (deltaX == deltaWidth && deltaY <= deltaHeight || deltaX <= deltaWidth && deltaY == deltaHeight) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean distincts(MyRectangle2D r) {
		double r_x1 = r.x - r.width / 2;
		double r_x2 = r.x + r.width / 2;
		double r_y1 = r.y - r.height / 2;
		double r_y2 = r.y + r.height / 2;
		
		double this_x1 = this.x - this.width / 2;
		double this_x2 = this.x + this.width / 2;
		double this_y1 = this.y - this.height / 2;
		double this_y2 = this.y + this.height / 2;
		
		if (r.distincts(this_x1, this_y1) && r.distincts(this_x2, this_y1) &&
				r.distincts(this_x1, this_y2) && r.distincts(this_x2, this_y2) &&
				this.distincts(r_x1, r_y1) && this.distincts(r_x2, r_y1) &&
				this.distincts(r_x1, r_y2) && this.distincts(r_x2, r_y2)) {
			return true;
		}
		else {
			return false;
		}
	}
}