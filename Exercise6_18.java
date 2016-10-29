/**
 * Program to check whether a string is a valid password
 * 
 * @author Lan Chang
 * @date 3/14/2016
 */

import java.util.Scanner;

public class Exercise6_18 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String pwd = null;
		
		int repeatInt = 1;
		System.out.println("This program is to check whether a string is a valid password.");
		System.out.println("Password rules: at least eight characters, at least two digits and only letters and digits.");
		
		while(repeatInt == 1) {
			try {
				System.out.println("Enter a password: ");
				pwd = input.next();
				
				Password myPassword = new Password(pwd);
				
				System.out.println("Valid Password.");
			}
			catch (IllegalArgumentException ex) {
				System.out.println("Exception: Invalid Password.");
			}
			
			System.out.print("Repeat program(1 for yes or 0 for no)?: ");
			repeatInt = input.nextInt();
		}
		System.out.println("Thank you for testing.");
	}
}

class Password {
	String pwd = null;
	
	public Password () {
	}
	
	public Password (String newPwd) throws IllegalArgumentException {
		pwd = newPwd;
		
		if (countNumber(pwd) >= 2 && pwd.length() == countNumber(pwd) + countDigit(pwd) && pwd.length() >= 8) {
		}
		
		else {
			throw new IllegalArgumentException("Invalid Password.");
		}
	}
	
	public int countNumber(String pwd) {
		int count = 0;	
		for (int i = 0; i < pwd.length(); i++) {
			char temp = pwd.charAt(i);
			if (temp >= '1' && temp <= '9') {
				count++;
			}
		}
		return count;
	}
	
	public int countDigit(String pwd) {
		int count = 0;
		for (int i = 0; i < pwd.length(); i++) {
			char temp = pwd.charAt(i);
			if (temp >= 'A' && temp <= 'Z' || temp >= 'a' && temp <= 'z') {
				count++;
			}
		}
		return count;
	}
}