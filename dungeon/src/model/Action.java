package model;

import java.util.Collection;

public enum Action {

	NORTH ('N', "to go to the north"),
	EAST ('E', "to go to the east"),
	WEST ('W', "to go to the west"),
	SOUTH ('S', "to go to the south"),
	ATTACK ('A', "to attack the ennemy"),
	HIT ('H', "to hit the enemy with your ", Weapon.FIST),
	POWERFUL_HIT ('P', "to hit your enemy two times at once with your ", Action.HIT.getWeapon(), 10),
	FLEE ('F', "to try to flee (10% chance of success)"), 
	TAKE ('T', "to take it"),
	LEAVE ('L', "to move on and leave it"), 
	DRINK ('D', "to drink it"),
	UNLOCK ('U', "to unlock the door"),
	START ('S', "to start the game"),
	CREDITS ('C', "to see the credits"),
	SILENCE ('S', "to set the game in silence mode"),
	LEVEL ('L', "to select a level"),
	MAKE ('M', "to make a new level"),
	NOISY ('N', "to set the game in noisy mode");
	
	private char action;
	private String description;
	private int chance;
	private Weapon weapon;
	
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
	 * @param action
	 * @param description
	 * @param chance
	 */
	private Action(char action, String description, int chance) {
		this(action, description);
		this.chance = chance;
	}

	/**
	 * @param action
	 * @param description
	 * @param weapon
	 */
	private Action(char action, String description, Weapon weapon) {
		this(action, description);
		this.setWeapon(weapon);
	}

	/**
	 * @param action
	 * @param description
	 * @param chance
	 * @param weapon
	 */
	private Action(char action, String description, Weapon weapon, int chance) {
		this(action, description, weapon);
		this.chance = chance;
	}

	/**
	 * @return the action
	 */
	public char getAction() {
		return action;
	}
	
	/**
	 * @param action the action to set
	 */
	public void setAction(char action) {
		this.action = action;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		
		String description = this.description;
		
		if (weapon != null)
			description += weapon.getName();
		
		if (this == HIT)
			description += " for " + weapon.getDamage() + " points";
		
		if (this == POWERFUL_HIT)
			description += " for " + (weapon.getDamage() * 2) + " points " + "(" + chance + "% of success)";
		
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the chance
	 */
	public int getChance() {
		return chance;
	}

	/**
	 * @param chance the chance to set
	 */
	public void setChance(int chance) {
		this.chance = chance;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public static Action getAction (char input) {
        for (Action action : values()) {
        	if (action.getAction() == input)
        		return action;
        }
        return null;
    }
	
	public static Action getAction (char input, Collection<Action> actions) {
        for (Action action : actions) {
        	if (action.getAction() == input)
        		return action;
        }
        return null;
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
