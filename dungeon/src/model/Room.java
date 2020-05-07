package model;
import java.util.*;

public class Room {

	private Collection<Item> items;
	private Collection<Transition> transitions;
	private boolean open;
	private String name;
	private HashMap<String, Room> neighbors;
	private Room north;
	private Room west;
	private Room east;
	private Room south;

	/**
	 * @param name
	 */
	public Room(String name) {
		this.name = name;
		neighbors = new HashMap<String, Room>();
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {

		this.name = name;
		
	}

	public Room getNorth() {
		return neighbors.get("north");
	}

	/**
	 * 
	 * @param north
	 */
	public void setNorth(Room north) {

		neighbors.put("north", north);
		
	}

	public Room getWest() {
		return neighbors.get("west");
	}

	/**
	 * 
	 * @param west
	 */
	public void setWest(Room west) {

		neighbors.put("west", west);
		
	}

	public Room getEast() {
		return neighbors.get("east");
	}

	/**
	 * 
	 * @param east
	 */
	public void setEast(Room east) {

		neighbors.put("east", east);
		
	}

	public Room getSouth() {
		return neighbors.get("south");
	}

	/**
	 * 
	 * @param south
	 */
	public void setSouth(Room south) {

		neighbors.put("south", south);
		
	}

	@Override
	public String toString() {
		return "I am the " + name + " room.";
	}
	
	public HashMap<String, Room> getNeighbors () {
		return neighbors;
	}

}