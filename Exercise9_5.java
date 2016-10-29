/**
 * Program to use the GregorianCalendar class to display the current year, month, and day
 * and set a specified elapsed time since January 1, 1970 and display the year, month, and day
 * 
 * @author Lan Chang
 * @date 3/9/2016
 */

import java.util.GregorianCalendar;

public class Exercise9_5 {
	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar();
		
		String[] month = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		System.out.println("This program is to use the GregorianCalendar class to display the current year, month, and day");
		System.out.println("and set a specified elapsed time since January 1, 1970 and display the year, month, and day.");
		
		int year1 = calendar.get(GregorianCalendar.YEAR);
		int month_num1 = calendar.get(GregorianCalendar.MONTH);
		int day1 = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		System.out.println("The current date is " + month[month_num1] + " " + day1 + ", " + year1);
		
		calendar.setTimeInMillis(1234567898765L);
		int year2 = calendar.get(GregorianCalendar.YEAR);
		int month_num2 = calendar.get(GregorianCalendar.MONTH);
		int day2 = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		System.out.println("The set date is " + month[month_num2] + " " + day2 + ", " + year2);
	}
}