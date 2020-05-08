package model;
public class Dungeon {

	private Room start;
	private Player player;
	
	/**
	 * Initiate a dungeon with a starting room
	 * @param start : initiate room
	 */
	public Dungeon(Room start) {
		super();
		this.start = start;
		player = new Player(start);
	}

	/**
	 * 
	 * @return initiate room
	 */
	public Room getStart() {
		return this.start;
	}

	/**
	 * 
	 * @param start the initiate room to set
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