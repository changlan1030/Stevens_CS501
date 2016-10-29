/**
 * Program to calculate the estimated area enclosed by four cities
 * 
 * @author Lan Chang
 * @date 2/11/2016
 */

import java.util.Scanner;

public class Exercise4_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double r = 6371.01;
		double atlantaX = 33.75;
		double atlantaY = 84.39;
		double orlandoX = 28.54;
		double orlandoY = 81.38;
		double savannahX = 32.08;
		double savannahY = 81.09;
		double charlotteX = 35.23;
		double charlotteY = 80.84;
		System.out.println("This program is to calculate the estimated area enclosed by four cities.");
		System.out.println("The four cities' latitude and longitude in degrees(info from http://www.latlong.net):");
		System.out.println("Atlanta: " + atlantaX + ", " + atlantaY);
		System.out.println("Orlando: " + orlandoX + ", " + orlandoY);
		System.out.println("Savannah: " + savannahX + ", " + savannahY);
		System.out.println("Charlotte: " + charlotteX + ", " + charlotteY);
		System.out.println("");
		
		// transform into radian
		double a1 = Math.toRadians(atlantaX);
		double b1 = Math.toRadians(atlantaY);
		double a2 = Math.toRadians(orlandoX);
		double b2 = Math.toRadians(orlandoY);
		double a3 = Math.toRadians(savannahX);
		double b3 = Math.toRadians(savannahY);
		double a4 = Math.toRadians(charlotteX);
		double b4 = Math.toRadians(charlotteY);
		
		// calculate the great circle distance between every two cities
		double d1 = r * Math.acos(Math.sin(a1) * Math.sin(a2) + Math.cos(a1) * Math.cos(a2) * Math.cos(b1 - b2));
		double d2 = r * Math.acos(Math.sin(a1) * Math.sin(a3) + Math.cos(a1) * Math.cos(a3) * Math.cos(b1 - b3));
		double d3 = r * Math.acos(Math.sin(a1) * Math.sin(a4) + Math.cos(a1) * Math.cos(a4) * Math.cos(b1 - b4));
		double d4 = r * Math.acos(Math.sin(a3) * Math.sin(a2) + Math.cos(a3) * Math.cos(a2) * Math.cos(b3 - b2));
		double d5 = r * Math.acos(Math.sin(a4) * Math.sin(a2) + Math.cos(a4) * Math.cos(a2) * Math.cos(b4 - b2));
		double d6 = r * Math.acos(Math.sin(a3) * Math.sin(a4) + Math.cos(a3) * Math.cos(a4) * Math.cos(b3 - b4));
		
		System.out.println("The distance between two cities:");
		System.out.println("Atlanta, Orlando: " + d1 + " km");
		System.out.println("Atlanta, Savannah: " + d2 + " km");
		System.out.println("Atlanta, Charlotte: " + d3 + " km");
		System.out.println("Orlando, Savannah: " + d4 + " km");
		System.out.println("Orlando, Charlotte: " + d5 + " km");
		System.out.println("Savannah, Charlotte: " + d6 + " km");
		System.out.println("");
		
		// calculate area enclosed by three cities and add
		double s1 = (d1 + d2 + d4) / 2;
		double area1 = Math.pow(s1 * (s1 - d1) * (s1 - d2) * (s1 - d4), 0.5);
		double s2 = (d3 + d2 + d6) / 2;
		double area2 = Math.pow(s2 * (s2 - d3) * (s2 - d2) * (s2 - d6), 0.5);
		double area5 = area1 + area2;
		System.out.println("The area enclosed by these four cities is " + area5 + " km^2");
		System.out.println("by using the distance between Atlanta and Savannah");
		System.out.println("and the area enclosed by Atlanta, Savannah and Orlando which is " + area1 + " km^2");
		System.out.println("and the area enclosed by Atlanta, Savannah and Charlotte which is " + area2 + " km^2");
		System.out.println("");
	    
		// calculate area enclosed by three cities and add
		double s3 = (d1 + d3 + d5) / 2;
		double area3 = Math.pow(s3 * (s3 - d1) * (s3 - d3) * (s3 - d5), 0.5);
		double s4 = (d4 + d6 + d5) / 2;
		double area4 = Math.pow(s4 * (s4 - d4) * (s4 - d6) * (s4 - d5), 0.5);
		double area6 = area3 + area4;
		System.out.println("The area enclosed by these four cities is " + area6 + " km^2");
		System.out.println("by using the distance between Orlando and Charlotte");
		System.out.println("and the area enclosed by Charlotte, Orlando and Atlanta which is " + area3 + " km^2");
		System.out.println("and the area enclosed by Charlotte, Orlando and Savannah which is " + area1 + " km^2");
	}
}