package model;
import java.util.*;

public abstract class Transition {

	private Collection<Item> items;
	private Collection<Trap> traps;
	private Collection<Room> directions;
	private Room access;
	
	/**
	 * @param access
	 */
	public Transition(Room access) {
		super();
		this.access = access;
	}

	/**
	 * @return the access
	 */
	public Room getAccess() {
		return access;
	}

	/**
	 * @param access the access to set
	 */
	public void setAccess(Room access) {
		this.access = access;
	}

}