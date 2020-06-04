package controller;

import model.Action;
import model.Game;
import model.Level;
import model.Menu;
import model.ResourceLoader;
import util.Console;
import view.MenuView;

/**
 * A controller class to manage the menu at the start of the game 
 * @author quentin
 *
 */
public class MenuController {

	private MenuView view;
	private Menu menu;
	
	/**
	 * @param view
	 * @param menu
	 */
	public MenuController(MenuView view, Menu menu) {
		this.view = view;
		this.menu = menu;
	} 
	
	/**
	 * A method to initiate the menu : it downloads the ressources from the server in a thread and ask the user for an action
	 */
	public void startMenu() {
		
		Runnable download = () -> {
			ResourceLoader.loadResource();
		};
		
		new Thread(download).start();
	
		int step = 1;
		
		while (!ResourceLoader.isLoaded()) {
			view.loading(step);
			step++;
		}
		
		view.menu();
		for (Action action : menu.getActions()) {
			view.action(action);
		}
		readAction();
	}
	
	/**
	 * method to read the action that the user has entered and execute it
	 */
	private void readAction () {
		
		for (Action action : menu.getActions()) {
			Console.addPattern(action.getAction());
		}
		
		char input = Console.read();
		Action action = Action.getAction(input, menu.getActions());
		System.out.println();
		
		executeAction(action);
		
	}
	
	/**
	 * method which was supposed to offer a selection of levels but I didn't manage to store levels in xml files
	 */
	private void selectLevel () {
		
	}
	
	/**
	 * method which was supposed to let the user create a game and upload it on the server
	 */
	private void makeLevel () {
		
	}
	
	/**
	 * Method to execute the action from a given action name
	 * @param action : action name to execute
	 */
	private void executeAction(Action action) {
		switch (action) {
		case START:
			menu.setDungeon(Level.initLevel1());
			menu.setGame(new Game(menu.getDungeon(), menu.isSilence()));
			menu.getGame().start();
			break;
		case LEVEL:
			selectLevel();
			break;
		case MAKE:
			makeLevel();
			break;
		case SILENCE:
			menu.setSilence(true);
			break;
		case NOISY:
			menu.setSilence(false);
			break;
		case CREDITS:
			view.credits();
		case QUIT:
			view.quit();
			System.exit(0);
		default:
			break;
		}
		
		startMenu();
	}
	
}
