package model;

import controller.DungeonController;
import view.DungeonView;

public class Game {

	private boolean win;
	private Dungeon dungeon;
	private DungeonController controller;
	private DungeonView view;
	private final int STATUES_GOAL;
	
	/**
	 * Starts a game with an initiate dungeon and a default number of 4 statues
	 * @param dungeon
	 */
	public Game(Dungeon dungeon) {
		// TODO Auto-generated constructor stub
		this(dungeon, 4);
	}
	
	/**
	 * Starts a game with an initiate dungeon and a number of statues to set
	 * @param dungeon
	 * @param statuesGoal
	 */
	public Game(Dungeon dungeon, int statuesGoal) {
		super();
		this.dungeon = dungeon;
		view = new DungeonView();
		controller = new DungeonController(this, view);
		this.STATUES_GOAL = statuesGoal;
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
	 * @return the STATUES_GOAL
	 */
	public int getSTATUES_GOAL() {
		return STATUES_GOAL;
	}

	/**
	 * Starts the game until it's over
	 */
	public void start () {
		controller.start();
		
		while (true) {
			controller.updatePlayerLocation();
			controller.describeRoom();
			if (controller.checkGameEnd())
				break;
			controller.readAction();
		}
		
//		try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}

}