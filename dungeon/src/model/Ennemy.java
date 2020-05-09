package model;

public abstract class Ennemy {

	private Action[] actions;
	private String name;
	
	/**
	 * @param name
	 */
	public Ennemy(String name) {
		super();
		this.name = name;
		initActions();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the actions
	 */
	public Action[] getActions() {
		return actions;
	}
	
	public void initActions () {
		actions = new Action[2];
		actions[0] = Action.ATTACK;
		actions[1] = Action.FLEE;
	}
	

}