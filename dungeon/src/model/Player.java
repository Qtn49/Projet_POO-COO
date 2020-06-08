package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.Console;

/**
 * class player which is inherited from fighter
 * this is the main character of the game
 * and the one that the user controls
 * @author quentin
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Player extends Fighter {

	@XmlElement
	private int nbHit = 0;
	@XmlElement
	private boolean missed;
	@XmlElement
	private ArrayList<Action> actions;
	
	public Player() {
		// TODO Auto-generated constructor stub
		this(null);
	}
	
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
		actions.add(Action.STATS);
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
	 * @param missed : the missed to set
	 */
	public void setMissed(boolean missed) {
		this.missed = missed;
	}

	/**
	 * @param action : the action to add
	 */
	public void addAction (Action action) {
		actions.add(action);
	}
	
	/**
	 * reset the actions he has
	 */
	public void resetActions () {
		actions.clear();
		actions.add(Action.STATS);
	}
	
	/**
	 * 
	 * @return chance
	 */
	public int getChance() {
		int chance = (nbHit * 10 + getEquipment().getCurrentWeapon().getChance()) % 100;
		
		if (chance == 0)
			chance = 100;
		
		return chance;
	}
	
	/**
	 * The player has a specific attack method
	 * because his chance increases if he doesn't use his powerfull hit
	 */
	@Override
	public void attack(Fighter fighter) {
		
		if (isCriticHit() && Console.getChance(getChance())) {
			missed = false;
			setDamage(getEquipment().getCurrentWeapon().getDamage() * 2);
		}else if (isCriticHit()) {
			setDamage(0);
		}else {
			nbHit++;
			setDamage(getEquipment().getCurrentWeapon().getDamage());
		}
		
		if (isCriticHit()) {
			setCriticHit(false);
			resetHit();
		}
		
		fighter.loseHealth(getDamage());
		
	}
	
	/**
	 * reset his hit
	 */
	public void resetHit() {
		nbHit = 0;
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

	/**
	 * take an item from his current room
	 * @param item
	 */
	public void takeItem(Item item) {

		getEquipment().addItem(getLocation().getEquipment().removeItem(item));
		
	}

}