package controller;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import model.Console;
import model.Direction;
import model.Dungeon;
import model.Game;
import model.Music;
import model.Room;
import view.DungeonView;

public class DungeonController {

	private static final int MAX_ACTION = 4;
	private Dungeon dungeon;
	private DungeonView view;
	private Game game;

	/**
	 * @param view
	 */
	public DungeonController(Game game, DungeonView view) {
		super();
		dungeon = game.getDungeon();
		this.game = game;
		this.view = view;
	}
	
	public Room	getPlayerPlace () {
		return dungeon.getPlayer().getCurrentLocation();
	}

	public void start() {

		view.playMusic(Music.INTRO);
		view.start();
		view.stopMusic();
	}

	public void getNeighbors() {

		view.printNeighbors(dungeon.getPlayer().getCurrentLocation());
		
	}
	
	public void askForAction () {
		
		System.out.println();
		view.printNeighbors(getPlayerPlace());
		
		if (dungeon.getPlayer().getCurrentLocation().getNeighbors().size() == 0) {
			game.setOver(true);
			return;
		}
			
		String pattern = view.askForAction (dungeon.getPlayer().getCurrentLocation());
		char input = Console.lire(Pattern.compile("(?i)[" + pattern + "]"));
		
		go(input);
		
	}
	
	public void go(char action) {
		switch (action) {
		case 'N':
			dungeon.getPlayer().goNorth();
			break;
		case 'E':
			dungeon.getPlayer().goEast();
			break;
		case 'W':
			dungeon.getPlayer().goWest();
			break;
		case 'S':
			dungeon.getPlayer().goSouth();
			break;
		}
	}
	
}
