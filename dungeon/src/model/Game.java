package model;

import controller.DungeonController;
import view.DungeonView;

public class Game {

	private boolean win;
	private Dungeon dungeon;
	private DungeonController controller;
	
	/**
	 * Starts a game with an initiate dungeon and a number of statues to set
	 * @param dungeon
	 * @param statuesGoal
	 */
	public Game(Dungeon dungeon) {
		this(dungeon, false);
	}

	/**
	 * @param dungeon
	 */
	public Game(Dungeon dungeon, boolean silence) {
		super();
		this.dungeon = dungeon;
		controller = new DungeonController(dungeon, new DungeonView(), silence);
	}

	/**
	 * check if the player win
	 * @return win
	 */
	public boolean isWin() {
		return win;
	}

	/**
	 * 
	 * @param win
	 */
	public void setWin(boolean win) {
		this.win = win;
	}

	/**
	 * 
	 * @return dungeon
	 */
	public Dungeon getDungeon() {
		return dungeon;
	}

	/**
	 * 
	 * @param dungeon
	 */
	public void setDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
	}
	
	/**
	 * 
	 * @return controller
	 */
	public DungeonController getController() {
		return controller;
	}

	/**
	 * Starts the game until it's over
	 */
	public void start () {
		controller.start();
		
		controller.updateView();
		
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}

}