package model;

import controller.DungeonController;
import view.DungeonView;

public class Game {

	private boolean over;
	private Dungeon dungeon;
	private DungeonController controller;
	private DungeonView view;
	
	/**
	 * @param dungeon
	 */
	public Game(Dungeon dungeon) {
		super();
		this.dungeon = dungeon;
		view = new DungeonView();
		controller = new DungeonController(dungeon, view);
	}

	public boolean isOver() {
		return over;
	}

	public void setOver(boolean over) {
		this.over = over;
	}

	public Dungeon getDungeon() {
		return dungeon;
	}

	public void setDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
	}
	
	/**
	 * @return the controller
	 */
	public DungeonController getController() {
		return controller;
	}

	/**
	 * @param controller the controller to set
	 */
	public void setController(DungeonController controller) {
		this.controller = controller;
	}

	public void start () {
		controller.start();
	}

}