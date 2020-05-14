package model;

public enum Item {

	STATUE ("statue of the youth", Action.TAKE),
	KEY ("magic key", Action.TAKE),
	POTION ("potion", Action.DRINK, 10);
	
	private String name;
	private Action action;
	private int points;
	
	/**
	 * @param name
	 */
	private Item(String name, Action action) {
		this.name = name;
		this.action = action;
	}

	/**
	 * @param name
	 * @param action
	 * @param points
	 */
	private Item(String name, Action action, int points) {
		this.name = name;
		this.action = action;
		this.points = points;
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
	
	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
}