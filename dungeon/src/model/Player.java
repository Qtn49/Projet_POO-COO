package model;

import java.util.ArrayList;
import java.util.Collection;

public class Player extends Character {

	private Game player;
	private Weapon weapon;
	private int health;
	private int statues;
	private boolean alive;
	private Room currentRoom;
	private ArrayList<Item> items;
	private ArrayList<Action> actions;

	public Player(Room room) {
	
		this("Thorn", room);		
	}
	
	/**
	 * initiate a player with its current {@link Room}
	 * @param currentRoom
	 */
	public Player(String name, Room currentRoom) {
		super(name);
		this.currentRoom = currentRoom;
		items = new ArrayList<Item>();
		actions = new ArrayList<Action>();
		alive = true;
		statues = 0;
	}

	/**
	 * @return the player
	 */
	public Game getPlayer() {
		return player;
	}



	/**
	 * @param player the player to set
	 */
	public void setPlayer(Game player) {
		this.player = player;
	}



	/**
	 * @return the weapon
	 */
	public Weapon getWeapon() {
		return weapon;
	}



	/**
	 * @param weapon the weapon to set
	 */
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}



	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}



	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}



	/**
	 * @return the alive
	 */
	public boolean isAlive() {
		return alive;
	}



	/**
	 * @param alive the alive to set
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}



	/**
	 * @return the currentLocation
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}



	/**
	 * @param currentRoom the currentLocation to set
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}



	/**
	 * @return the statues
	 */
	public int getStatues() {
		return statues;
	}

	/**
	 * @param statues the statues to set
	 */
	public void setStatues(int statues) {
		this.statues = statues;
	}

	/**
	 * @return the actions
	 */
	public ArrayList<Action> getActions() {
		return actions;
	}

	/**
	 * @param actions the actions to set
	 */
	public void addAction (Action action) {
		actions.add(action);
	}
	
	public void takeItem() {
		if (currentRoom.getItem() instanceof Statue)
			statues++;
		currentRoom.setItem(null);
	}
	
	public void resetActions () {
		actions.clear();
	}

	/**
	 * 
	 * @param prisonner
	 */
	public void free(Prisonner prisonner) {
		// TODO - implement Player.free
		throw new UnsupportedOperationException();
	}

	/**
	 * move the player to the given {@link Direction}
	 * @param direction
	 */
	public void move(Direction direction) {
		setCurrentRoom(getCurrentRoom().getTransitions().get(direction).getRoom());
	}

}