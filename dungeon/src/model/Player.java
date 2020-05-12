package model;

import java.util.ArrayList;

import utility.Console;

public class Player extends Fighter {

	private int nbCombats = 0;
	
	private ArrayList<Action> actions;
	public Player(Room location) {
	
		this("Thorn", location);	
	}
	
	/**
	 * initiate a player with its current {@link Room}
	 * @param currentRoom
	 */
	public Player(String name, Room location) {
		this(name, location, 100, Weapon.FIST);
	}

	/**
	 * @param name
	 * @param location
	 * @param maxHealth
	 * @param weapon
	 */
	public Player(String name, Room location, int maxHealth, Weapon weapon) {
		super(name, location, maxHealth, weapon);
		actions = new ArrayList<Action>();
	}


	/**
	 * @return the actions
	 */
	public ArrayList<Action> getActions() {
		return actions;
	}

	public int getNbCombats() {
		return nbCombats;
	}
	
	public void addCombat () {
		nbCombats++;
	}

	/**
	 * @param actions the actions to set
	 */
	public void addAction (Action action) {
		actions.add(action);
	}
	
	public void takeStatue () {
		getEquipment().addStatue(getLocation().getEquipment().removeStatue());
	}
	
	public void resetActions () {
		actions.clear();
	}
	
	@Override
	public int getDamage() {

		int damage = getEquipment().getCurrentWeapon().getDamage();
		int chance = (nbCombats * 10) % 101;
		
		isCriticHit()
		criticHit = Console.getChance();
		
		return criticHit ? damage * 2 : damage;
		
	}

	/**
	 * 
	 * @param prisonner
	 */
	public void free(Prisonner prisonner) {
		// TODO - implement Player.free
		throw new UnsupportedOperationException();
	}

	/**
	 * move the player to the given {@link Direction}
	 * @param direction
	 */
	public void move(Direction direction) {
		
		setLocation(getLocation().getTransitions().get(direction).getRoom());
		
	}

}