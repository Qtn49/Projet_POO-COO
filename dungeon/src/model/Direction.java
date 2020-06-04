package model;

import javax.xml.bind.annotation.XmlEnum;

/**
 * enumeration that lists all directions (north, east, west, south)
 * it can give an opposite direction
 * @author quentin
 *
 */
@XmlEnum
public enum Direction {
	
	NORTH ("north", Action.NORTH),
	EAST ("east", Action.EAST),
	WEST ("west", Action.WEST),
	SOUTH ("south", Action.SOUTH);
	
	private String direction;
	private Action action;
	
	/**
	 * Constructor for Direction
	 * @param direction : a direction to point to
	 * @param action : the associated action enum
	 */
	Direction(String direction, Action action) {
		
		this.direction = direction;
		this.action = action;
	}
	
	/**
	 * @return the direction as an action enum
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * return the name of the direction in lower case
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return direction;
	}
	
	/**
	 * Method to get the opposed direction
	 * @return a Direction enum
	 */
	public Direction opposedDirection () {
		
		Direction opposed = null;
		
		switch (this) {
		case NORTH:
			opposed = SOUTH;
			break;
		case SOUTH:
			opposed = NORTH;
			break;
		case EAST:
			opposed = WEST;
			break;
		case WEST:
			opposed = EAST;
			break;
		}
		
		return opposed;
	}
	
}
