package model;

import java.util.ArrayList;
import java.util.Collection;

public class Player {

	private Game player;
	private Weapon weapon;
	private int health;
	private boolean alive;
	private Room currentLocation;
	private int statues;
	private Collection<Action> actions;

	/**
	 * initiate a player with its current {@link Room}
	 * @param currentLocation
	 */
	public Player(Room currentLocation) {
		this.currentLocation = currentLocation;
		statues = 0;
		actions = new ArrayList<Action>();
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
	public Room getCurrentLocation() {
		return currentLocation;
	}



	/**
	 * @param currentLocation the currentLocation to set
	 */
	public void setCurrentLocation(Room currentLocation) {
		this.currentLocation = currentLocation;
	}



	/**
	 * @return the actions
	 */
	public Collection<Action> getActions() {
		return actions;
	}

	/**
	 * @param actions the actions to set
	 */
	public void addAction (Action action) {
		actions.add(action);
	}
	
	public void resetAction () {
		actions.clear();
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
	public void addStatue () {
		statues++;
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
		setCurrentLocation(getCurrentLocation().getNeighbors().get(direction));
	}

}