package model;
public class Dungeon {

	private Room start;
	private Player player;
	
	/**
	 * @param start
	 */
	public Dungeon(Room start) {
		super();
		this.start = start;
		player = new Player(start);
	}

	public Room getStart() {
		return this.start;
	}

	/**
	 * 
	 * @param start
	 */
	public void setStart(Room start) {

		this.start = start;
		
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

}