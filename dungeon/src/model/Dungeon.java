package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dungeon {

	private Room start;
	private Player player;
	private final int STATUES_GOAL;
	
	public Dungeon (Room start) {
		this(start, 4);
	}
	
	/**
	 * Initiate a dungeon with a starting room
	 * @param start : initiate room
	 */
	public Dungeon(Room start, int statues) {
		super();
		this.start = start;
		player = new Player(start);
		STATUES_GOAL = statues;
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

	/**
	 * @return the sTATUES_GOAL
	 */
	public int getSTATUES_GOAL() {
		return STATUES_GOAL;
	}

}