package model;

public enum Action {

	NORTH ('N', "go to the north"),
	EAST ('E', "go to the east"),
	WEST ('W', "go to the west"),
	SOUTH ('S', "go to the south");
	
	private char action;
	private String description;
	
	/**
	 * Contructor for Action
	 * @param action : input of the action
	 * @param description : description of the action
	 */
	private Action(char action, String description) {
		this.action = action;
		this.description = description;
	}

	/**
	 * @return the action
	 */
	public char getAction() {
		return action;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the action input as a string
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + action;
	}

}
