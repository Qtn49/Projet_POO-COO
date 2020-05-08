package model;

public enum Direction {
	
	NORTH ("north", 'N'),
	EAST ("east", 'E'),
	WEST ("west", 'W'),
	SOUTH ("south", 'S');
	
	private String direction;
	private char nickname;
	
	Direction(String direction, char nickname) {
		
		this.direction = direction;
		this.nickname = nickname;
	}
	
	public Direction getDirection(char nickname) {
		switch (nickname) {
		case 'N':
			return NORTH;
		case 'E':
			return EAST;
		case 'W':
			return WEST;
		default:
			return SOUTH;
		}
	}
	
	/**
	 * @return the nickname
	 */
	public char getNickname() {
		return nickname;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return direction;
	}
	
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
