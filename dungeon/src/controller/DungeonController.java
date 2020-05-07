package controller;

import model.Dungeon;
import model.Room;
import view.DungeonView;

public class DungeonController {

	private Dungeon dungeon;
	private DungeonView view;

	/**
	 * @param view
	 */
	public DungeonController(Dungeon dungeon, DungeonView view) {
		super();
		this.dungeon = dungeon;
		this.view = view;
	}
	
	public Room	getPlayerPlace () {
		return dungeon.getPlayer().getCurrentLocation();
	}

	public void start() {

		view.start();
		
	}

	public void getNeighbors() {

		view.printNeighbors(dungeon.getPlayer().getCurrentLocation());
		
	}
	
}
