package model;

import javax.xml.bind.annotation.*;

/**
 * class that holds the first room, the number of statues to get and the player
 * @author quentin
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Player.class, Room.class})
public class Dungeon {

	private static final int DEFAULT_STATUES = 4;
	@XmlElement(name = "start")
	private Room start;
	@XmlElement
	private Player player;
	@XmlElement
	private final int STATUES_GOAL;
	
	/**
	 * empty constructor that was initially made to make mapping possible
	 */
	public Dungeon() {
		// TODO Auto-generated constructor stub
		this(new Room("This is the first room of the dungeon"));
	}
	
	/**
	 * 
	 * @param start
	 */
	public Dungeon (Room start) {
		this(start, DEFAULT_STATUES);
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