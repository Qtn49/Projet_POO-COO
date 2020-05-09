package utility;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Console {

	private static final int TIME = 50;
	private static Scanner scan = new Scanner(System.in);
	private static String pattern = "(?i)[";

	/**
	 * Method to print text in a fancy way
	 * @param string : the text to print
	 * @param jumpline : true adds a new line at the end
	 */
	public static void print (Object object, boolean jumpline) {
		
		String text = object.toString();
		
		if (jumpline)
			text += '\n';
		
		for (int i = 0; i < text.length(); i++) {
			
			System.out.print(text.charAt(i));
			
			try {
				Thread.sleep(TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		try {
			Thread.sleep(TIME * 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Default print method which adds a new line
	 * @param string : text to print
	 */
	public static void print (Object object) {
		
		print(object, true);
		
	}
	
	/**
	 * @param a regex pattern to check what input is required
	 * Read a character
	 * @return the input
	 */
	public static char read () {
		
		char input = ' ';
		
		print("=>", false);
		pattern += "]";
		
		// check if the token consists of the declared pattern
		while(!scan.hasNext(pattern)){
			
			System.out.print("Sorry, something went wrong. \n=>");
			scan.next();
		
		}
		
		input = scan.next().toUpperCase().charAt(0);

		pattern = "(?i)[";
		
		return input;
		
	}
	
	public static void addPattern (char input) {
		
		pattern += input;
		
	}
	
}
