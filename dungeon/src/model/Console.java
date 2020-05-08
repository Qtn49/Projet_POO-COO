package model;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Console {

	private static final int TIME = 50;
	private static Scanner scan = new Scanner(System.in);

	public static void print (String string, boolean jumpline) {
		
		for (int i = 0; i < string.length(); i++) {
			
			System.out.print(string.charAt(i));
			
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
		
		if (jumpline)
			System.out.println();
		
	}
	
	public static void print (String string) {
		
		print(string, true);
		
	}
	
	/**
	 * @param a regex pattern to check what input is required
	 * Read a character
	 * @return the input
	 */
	public static char lire (Pattern pattern) {
		
		char input = ' ';
		
		// check if the token consists of the declared pattern
		while(!scan.hasNext(pattern)){
			
			System.out.print("Sorry, something went wrong. \n=>");
			scan.next();
		
		}
		
		input = scan.next().toUpperCase().charAt(0);

		return input;
		
	}
	
}
