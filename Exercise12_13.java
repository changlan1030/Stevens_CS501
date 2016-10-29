/**
 * Program to count characters, words, and lines in a file
 * 
 * @author Lan Chang
 * @date 3/16/2016
 */

import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Exercise12_13 {
	public static void main(String[] args) {
		int repeatInt = 1;
		System.out.println("This program is to count characters, words, and lines in a file.");
		
		while(repeatInt == 1) {
			try {
				// use filechooser to pop up a director screen
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Documents (*.txt)", "txt");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(null);
				String filename = chooser.getSelectedFile().getName();
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("You chose to open this file: " + filename);
				}
			    
				// get the file
				File file = chooser.getSelectedFile();
				Scanner fileInput = new Scanner(file);
				
				// initialize four variable to count
				int countChar = 0;
				int countWord = 0;
				int countLine = 0;
				int countSpace = 0;
				
				while (fileInput.hasNext()) {
					String s = fileInput.nextLine();              // read a line ending with a line separator
					countWord = countWordFunc(s) + countWord;     // count the word
					countChar = s.length() + countChar;           // count the character
					countSpace = countSpaceFunc(s) + countSpace;  // count the space
					countLine++;                                  // count the line
				}
				
				int countChar2 = countChar - countSpace;
				
				// output
				System.out.println("Words: " + countWord);
				System.out.println("Characters(with spaces): " + countChar);
				System.out.println("Characters(no spcaes): " + countChar2);
				System.out.println("Lines: " + countLine);
				
				// close the file
				fileInput.close();
			}
			catch (Exception e) {
				System.out.println("Exception: Open ERROR.");
			}
			
			Scanner intInput = new Scanner(System.in);
			System.out.print("Repeat program(1 for yes or 0 for no)?: ");
			repeatInt = intInput.nextInt();
		}
		System.out.println("Thank you for testing.");
	}
	
	public static int countWordFunc(String s) {
		int wordCount = 0;
		Scanner wordInput = new Scanner(s);
		
		// count the word
		while (wordInput.hasNext()) {
			String word = wordInput.next();
			wordCount++;
		}
		return wordCount;
	}
	
	public static int countSpaceFunc(String s) {
		int spaceCount = 0;
		for(int i = 0;i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == ' ') {
				spaceCount++;
			}		
		}
		return spaceCount;
	}
}