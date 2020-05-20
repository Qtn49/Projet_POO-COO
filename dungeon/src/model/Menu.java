package model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Menu {

	private Game game;
	private boolean silence;
	private ArrayList<Action> actions;
	private Dungeon dungeon;
	
	public Menu() {
		
		actions = new ArrayList<>();
		actions.add(Action.LEVEL);
		actions.add(Action.MAKE);
		actions.add(Action.SILENCE);
		actions.add(Action.CREDITS);
		
	}
	
	public void startGame () {
		game = new Game(dungeon, silence);
	}

	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * @return the silencew
	 */
	public boolean isSilence() {
		return silence;
	}

	/**
	 * @param silence the silence to set
	 */
	public void setSilence(boolean silence) {
		
		int index = (this.silence) ? actions.indexOf(Action.NOISY) : actions.indexOf(Action.SILENCE);
				
		actions.set(index, (silence) ? Action.NOISY : Action.SILENCE);
		
		
		this.silence = silence;
		
	}

	/**
	 * @return the dungeon
	 */
	public Dungeon getDungeon() {
		return dungeon;
	}

	/**
	 * @param dungeon the dungeon to set
	 */
	public void setDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
		actions.add(0, Action.START);
	}

	/**
	 * @return the actions
	 */
	public ArrayList<Action> getActions() {
		return actions;
	}

}
