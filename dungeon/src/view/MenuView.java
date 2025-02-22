package view;

import model.Action;
import model.Contributor;
import util.Console;

/**
 * class that display the menu
 * @author quentin
 *
 */
public class MenuView {

	/**
	 * generates some text during the downloading
	 * @param step
	 */
	public void loading (int step) {
		switch (step) {
		case 1:
			Console.print("\n" + 
					"\n" + 
					"               .__                                  __             __  .__                 .___                                        \n" + 
					"__  _  __ ____ |  |   ____  ____   _____   ____   _/  |_  ____   _/  |_|  |__   ____     __| _/_ __  ____    ____   ____  ____   ____  \n" + 
					"\\ \\/ \\/ // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\  \\   __\\/  _ \\  \\   __\\  |  \\_/ __ \\   / __ |  |  \\/    \\  / ___\\_/ __ \\/  _ \\ /    \\ \n" + 
					" \\     /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/   |  | (  <_> )  |  | |   Y  \\  ___/  / /_/ |  |  /   |  \\/ /_/  >  ___(  <_> )   |  \\\n" + 
					"  \\/\\_/  \\___  >____/\\___  >____/|__|_|  /\\___  >  |__|  \\____/   |__| |___|  /\\___  > \\____ |____/|___|  /\\___  / \\___  >____/|___|  /\n" + 
					"             \\/          \\/            \\/     \\/                            \\/     \\/       \\/          \\//_____/      \\/           \\/ \n" + 
					"\n" + 
					"", false, 25);
			break;
		case 2:
			Console.print("\n" + 
					"\n" + 
					"__________.__                                                .__  __            .__    .__.__             __  .__                                            .__         .__                    .___.__                \n" + 
					"\\______   \\  |   ____ _____    ______ ____   __  _  _______  |__|/  |_  __  _  _|  |__ |__|  |   ____   _/  |_|  |__   ____      _________    _____   ____   |__| ______ |  |   _________     __| _/|__| ____    ____  \n" + 
					" |     ___/  | _/ __ \\\\__  \\  /  ___// __ \\  \\ \\/ \\/ /\\__  \\ |  \\   __\\ \\ \\/ \\/ /  |  \\|  |  | _/ __ \\  \\   __\\  |  \\_/ __ \\    / ___\\__  \\  /     \\_/ __ \\  |  |/  ___/ |  |  /  _ \\__  \\   / __ | |  |/    \\  / ___\\ \n" + 
					" |    |   |  |_\\  ___/ / __ \\_\\___ \\\\  ___/   \\     /  / __ \\|  ||  |    \\     /|   Y  \\  |  |_\\  ___/   |  | |   Y  \\  ___/   / /_/  > __ \\|  Y Y  \\  ___/  |  |\\___ \\  |  |_(  <_> ) __ \\_/ /_/ | |  |   |  \\/ /_/  >\n" + 
					" |____|   |____/\\___  >____  /____  >\\___  >   \\/\\_/  (____  /__||__|     \\/\\_/ |___|  /__|____/\\___  >  |__| |___|  /\\___  >  \\___  (____  /__|_|  /\\___  > |__/____  > |____/\\____(____  /\\____ | |__|___|  /\\___  / \n" + 
					"                    \\/     \\/     \\/     \\/                \\/                        \\/             \\/             \\/     \\/  /_____/     \\/      \\/     \\/          \\/                  \\/      \\/         \\//_____/  \n" + 
					"\n" + 
					"", false, 25);
			break;
		case 3:
			Console.print("\n" + 
					"\n" + 
					"  _________                              _____                __  .__                             .__  __   \n" + 
					" /   _____/ __________________ ___.__. _/ ____\\___________  _/  |_|  |__   ____   __  _  _______  |__|/  |_ \n" + 
					" \\_____  \\ /  _ \\_  __ \\_  __ <   |  | \\   __\\/  _ \\_  __ \\ \\   __\\  |  \\_/ __ \\  \\ \\/ \\/ /\\__  \\ |  \\   __\\\n" + 
					" /        (  <_> )  | \\/|  | \\/\\___  |  |  | (  <_> )  | \\/  |  | |   Y  \\  ___/   \\     /  / __ \\|  ||  |  \n" + 
					"/_______  /\\____/|__|   |__|   / ____|  |__|  \\____/|__|     |__| |___|  /\\___  >   \\/\\_/  (____  /__||__|  \n" + 
					"        \\/                     \\/                                      \\/     \\/                \\/          \n" + 
					"\n" + 
					"", false, 25);

		default:
			Console.print("\n" + 
					"\n" + 
					".__                    .___.__                           \n" + 
					"|  |   _________     __| _/|__| ____    ____             \n" + 
					"|  |  /  _ \\__  \\   / __ | |  |/    \\  / ___\\            \n" + 
					"|  |_(  <_> ) __ \\_/ /_/ | |  |   |  \\/ /_/  >           \n" + 
					"|____/\\____(____  /\\____ | |__|___|  /\\___  / /\\  /\\  /\\ \n" + 
					"                \\/      \\/         \\//_____/  \\/  \\/  \\/ \n" + 
					"\n" + 
					"", false, 25);
			break;
		}
	}
	
	/**
	 * welcome message
	 */
	public void menu() {
		
		Console.print("Welcome to the infernal dungeon !");
		Console.print("Here's the menu, choose an action from below");
		
	}

	/**
	 * describe action to be used
	 * @param action
	 */
	public void action(Action action) {
		
		Console.print("\t(" + action.getAction() + ") - " + action.getDescription());
		
	}

	/**
	 * describe the credits
	 */
	public void credits() {
		
		Console.print("Thanks to :");
		
		for (Contributor contributor : Contributor.values()) {
			
			Console.print("\t- " + contributor.getFirstName() + " " + contributor.getLastName() + " " + contributor.getContribution());
			
		}
		
		System.out.println();
		
	}

	/**
	 * quit
	 */
	public void quit() {
		// TODO Auto-generated method stub
		
		Console.print("Well bye, hope you had a good time !");
		
	}

}
