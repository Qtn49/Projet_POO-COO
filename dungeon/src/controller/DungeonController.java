package controller;

import java.util.regex.Pattern;

import model.Direction;
import model.Dungeon;
import model.Game;
import model.Music;
import model.Player;
import model.Room;
import model.Statue;
import utility.Console;
import view.DungeonView;

public class DungeonController {

//	private static final int MAX_ACTION = 4;
	private Dungeon dungeon;
	private DungeonView view;
	Game game;

	/**
	 * initiate the controller
	 * @param game
	 * @param view
	 */
	public DungeonController(Game game, DungeonView view) {
		super();
		this.game = game;
		dungeon = game.getDungeon();
		this.view = view;
	}
	
	

	public void start() {

		updatePlayerLocation();
		view.start(game.getSTATUES_GOAL());
	}
	
	public void updatePlayerLocation () {
		
		Player player = dungeon.getPlayer();
		
		if (player.getCurrentLocation().getNeighbors().size() == 0) {
//			throw new GameBuildException();
		}
		
		if (player.getCurrentLocation().getItem() instanceof Statue) {
			dungeon.getPlayer().addStatue();
		}
		
		player.resetAction();
		
		view.playMusic(dungeon.getPlayer().getCurrentLocation().getMusic());
		
		for (Direction direction : player.getCurrentLocation().getNeighbors().keySet()) {
			player.addAction(direction.getAction());
		}
		
	}
	
	/**
	 * check if the game ends
	 * @return the game end
	 */
	public boolean checkGameEnd () {
		if (dungeon.getPlayer().getStatues() == game.getSTATUES_GOAL()) {
			game.setWin(true);
			return true;
		}
		return false;
	}
	
	/**
	 * call to describe room from {@link DungeonView}
	 */
	public void describeRoom () {
		
		System.out.println();
		view.describeRoom(dungeon.getPlayer().getCurrentLocation());
		
	}
		
	/**
	 * read an input for an action
	 */
	public void readAction() {
		
		String pattern = view.askForAction (dungeon.getPlayer().getCurrentLocation());
		char input = Console.lire(Pattern.compile("(?i)[" + pattern + "]"));
		
		go(input);
		
	}
	
	/**
	 * execute the given action
	 * @param action
	 */
	public void go(char action) {
		switch (action) {
		case 'N':
			dungeon.getPlayer().move(Direction.NORTH);
			break;
		case 'E':
			dungeon.getPlayer().move(Direction.EAST);
			break;
		case 'W':
			dungeon.getPlayer().move(Direction.WEST);
			break;
		case 'S':
			dungeon.getPlayer().move(Direction.SOUTH);
			break;
		}
	}
	
}
