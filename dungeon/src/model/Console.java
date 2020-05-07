package model;

public class Console {

	private static final int TIME = 50;

	public static void print (String string) {
		
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
		
		System.out.println();
		
	}
	
}
