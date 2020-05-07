package model;
public class Player {

	private Game player;
	private Weapon weapon;
	private int health;
	private boolean alive;
	private Room currentLocation;

	

	/**
	 * @param currentLocation
	 */
	public Player(Room currentLocation) {
		this.currentLocation = currentLocation;
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
	 * 
	 * @param prisonner
	 */
	public void free(Prisonner prisonner) {
		// TODO - implement Player.free
		throw new UnsupportedOperationException();
	}

}