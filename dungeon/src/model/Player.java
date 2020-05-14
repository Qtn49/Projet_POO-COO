package model;

import java.util.ArrayList;

import utility.Console;

public class Player extends Fighter {

	private int nbHit = 1;
	private boolean missed;
	
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

	public int getHit() {
		return nbHit;
	}
	
	/**
	 * @return the missed
	 */
	public boolean isMissed() {
		return missed;
	}

	/**
	 * @param missed the missed to set
	 */
	public void setMissed(boolean missed) {
		this.missed = missed;
	}

	/**
	 * @param actions the actions to set
	 */
	public void addAction (Action action) {
		actions.add(action);
	}
	
	public void takeStatue () {
		getEquipment().addItem(getLocation().getEquipment().removeStatue());
	}
	
	public void resetActions () {
		actions.clear();
	}
	
	@Override
	public int getChance() {
		int chance = (nbHit * 10) % 100;
		
		if (chance == 0)
			chance = 100;
		
		return chance;
	}
	
	@Override
	public void attack(Fighter fighter) {
		
		if (isCriticHit() && Console.getChance(getChance())) {
			missed = false;
			setCriticHit(true);
			setDamage(getEquipment().getCurrentWeapon().getDamage() * 2);
		}else if (isCriticHit())
			setDamage(0);
		else {
			nbHit++;
			setDamage(getEquipment().getCurrentWeapon().getDamage());
		}
		
		fighter.loseHealth(getDamage());
		
	}
	
	public void resetHit() {
		nbHit = 1;
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

	public void takeItem(Item item) {

		getEquipment().addItem(getLocation().getEquipment().removeItem(item));
		
	}

}