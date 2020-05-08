package model;
import java.util.*;

public class Room {

	private Collection<Item> items;
	private boolean open;
	private String description;
	private HashMap<Direction, Room> neighbors;
	private HashMap<Direction, Door> doors;

	/**
	 * @param description
	 */
	public Room(String description) {
		this.description = description;
		neighbors = new HashMap<Direction, Room>();
		doors = new HashMap<Direction, Door>();

	}

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

	public HashMap<Direction, Room> getNeighbors () {
		return neighbors;
	}
	

	public void setNeighbors (Direction direction, Room room) {
		setNeighbors(direction, room, true);
	}

	/**
	 * @param neighbors the neighbors to set
	 */
	public void setNeighbors(Direction direction, Room room, boolean bothside) {
		
		neighbors.put(direction, room);
		if (bothside)
			room.neighbors.put(direction.opposedDirection(), this);
		
	}

	public Door getDoor(Direction direction) {
		return doors.get(direction);
	}
	
	public void setDoor(Direction direction, Door door) {
		doors.put(direction, door);
	}

	@Override
	public String toString() {
		return description;
	}

}