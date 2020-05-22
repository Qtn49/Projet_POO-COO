package controller;

import model.Action;
import model.Game;
import model.Level;
import model.Menu;
import model.ResourceLoader;
import utility.Console;
import view.MenuView;

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
	
	private void readAction () {
		
		for (Action action : menu.getActions()) {
			Console.addPattern(action.getAction());
		}
		
		char input = Console.read();
		Action action = Action.getAction(input, menu.getActions());
		System.out.println();
		
		executeAction(action);
		
	}
	
//	private void selectLevel () {
//		
//	}
	
	private void executeAction(Action action) {
		switch (action) {
		case START:
			if (!ResourceLoader.isLoaded())
				menu.setSilence(false);
			menu.setGame(new Game(menu.getDungeon(), menu.isSilence()));
			menu.getGame().start();
			break;
		case LEVEL:
			menu.setDungeon(Level.initLevel1());
			break;
		case SILENCE:
			menu.setSilence(true);
			break;
		case NOISY:
			menu.setSilence(false);
			break;
		case CREDITS:
			view.credits();
		default:
			break;
		}
		
		startMenu();
	}
	
}
