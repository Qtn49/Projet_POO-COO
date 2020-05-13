package model;

public enum Item {

	STATUE ("statue of the youth", Action.TAKE),
	KEY ("magic key", Action.TAKE),
	POTION ("potion", Action.DRINK);
	
	private String name;
	private Action action;
	
	/**
	 * @param name
	 */
	private Item(String name, Action action) {
		this.name = name;
		this.action = action;
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
	 * @return the action
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(Action action) {
		this.action = action;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
}