package view;

import model.Action;
import model.Contributor;
import utility.Console;

public class MenuView {

	public void menu() {
		
		Console.print("Welcome to the infernal dungeon !");
		Console.print("Here's the menu, choose an action from below");
		
	}
	
	public void action(Action action) {
		
		Console.print("\t(" + action.getAction() + ") - " + action.getDescription());
		
	}

	public void credits() {
		
		Console.print("Thanks to :");
		
		for (Contributor contributor : Contributor.values()) {
			
			Console.print("\t- " + contributor.getFirstName() + " " + contributor.getLastName() + " " + contributor.getContribution());
			
		}
		
		System.out.println();
		
	}

}
