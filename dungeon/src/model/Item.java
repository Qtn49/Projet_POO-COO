package model;

import java.util.ArrayList;

public abstract class Item {

	private ArrayList<Action> actions;
	private String name;
	
	/**
	 * @param name
	 */
	public Item(String name) {
		super();
		this.name = name;
		actions = new ArrayList<Action>();
	}

	public ArrayList<Action> getActions() {
		return actions;
	}
	
	public void addAction (Action action) {
		actions.add(action);
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
	
}