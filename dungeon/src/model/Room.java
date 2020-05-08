package model;
import java.util.*;

public class Room {

	private Item item;
	private String description;
	private HashMap<Direction, Room> neighbors;
	private HashMap<Direction, Door> doors;
	private Music music;

	/**
	 * Initiate a room with a default music
	 * @param description
	 */
	public Room(String description) {
		this.description = description;
		neighbors = new HashMap<Direction, Room>();
		doors = new HashMap<Direction, Door>();
		music = Music.THEME;
	}

	/**
	 * initiate a room with a given music
	 * @param description
	 * @param music
	 */
	public Room(String description, Music music) {
		super();
		this.description = description;
		this.music = music;
	}



	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param items the items to set
	 */
	public void setItem (Item item) {
		this.item = item;
	}

	/**
	 * 
	 * @return the description
	 */
	public String getName() {
		return this.description;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {

		this.description = name;
		
	}

	/**
	 * 
	 * @return the neighbors
	 */
	public HashMap<Direction, Room> getNeighbors () {
		return neighbors;
	}
	

	/**
	 * add a neighbor room to the given direction 
	 * @param direction
	 * @param room
	 */
	public void setNeighbors (Direction direction, Room room) {
		setNeighbors(direction, room, true);
	}

	/**
	 * add a neighbor room to the given direction with a given parameter for setting only one path
	 * @param direction
	 * @param room
	 * @param bothside
	 */
	public void setNeighbors(Direction direction, Room room, boolean bothside) {
		
		neighbors.put(direction, room);
		if (bothside)
			room.neighbors.put(direction.opposedDirection(), this);
		
	}

	/**
	 * 
	 * @param direction
	 * @return the {@link Door} a the given {@link Direction} 
	 */
	public Door getDoor(Direction direction) {
		return doors.get(direction);
	}
	
	/**
	 * 
	 * @param direction
	 * @param door
	 */
	public void setDoor(Direction direction, Door door) {
		doors.put(direction, door);
	}

	/**
	 * @return the music
	 */
	public Music getMusic() {
		return music;
	}

	/**
	 * @param music the music to set
	 */
	public void setMusic(Music music) {
		this.music = music;
	}

	/**
	 * @return the description of the room
	 */
	@Override
	public String toString() {
		return description;
	}

}