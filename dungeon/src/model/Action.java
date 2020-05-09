package model;

public enum Action {

	NORTH ('N', "to go to the north"),
	EAST ('E', "to go to the east"),
	WEST ('W', "to go to the west"),
	SOUTH ('S', "to go to the south"),
	ATTACK ('A', "to attack the ennemy"),
	FLEE ('F', "to try to flee (20% chance of success)"), 
	TAKE ('T', "to take it"),
	LEAVE ('L', "to move on and leave it");
	
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
	
	public static Action getAction (char input) {
        for (Action action : values()) {
        	if (action.action == input)
        		return action;
        }
        return null;
    }
	
	public boolean isDirection () {
		return this == NORTH || this == EAST || this == WEST || this == SOUTH;
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
