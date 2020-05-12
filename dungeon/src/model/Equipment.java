package model;

import java.util.ArrayList;
import java.util.Stack;

public class Equipment {

	private Stack<Statue> statues;
	private ArrayList<Weapon> weapons;
	private ArrayList<Key> keys;
	private Weapon currentWeapon;
	
	public Equipment () {
		statues = new Stack<Statue>();
		weapons = new ArrayList<Weapon>();
		keys = new ArrayList<Key>();
	}

	/**
	 * @return the weapons
	 */
	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

	/**
	 * @return the currentWeapon
	 */
	public Weapon getCurrentWeapon() {
		return currentWeapon;
	}

	/**
	 * @param currentWeapon the currentWeapon to set
	 */
	public void setCurrentWeapon(Weapon currentWeapon) {
		this.currentWeapon = currentWeapon;
	}

	/**
	 * @return the keys
	 */
	public ArrayList<Key> getKeys() {
		return keys;
	}

	public void addStatue (Statue statue) {
		statues.push(statue);
	}
	
	public int nbStatues () {
		return statues.size();
	}
	
	public boolean hasStatue () {
		return statues.size() > 0;
	}
	
	public Statue getLastStatue () {
		return statues.peek();
	}
	
	public Statue removeStatue () {
		return statues.pop();
	}
	
	public void addWeapon (Weapon weapon) {
		weapons.add(weapon);
		
		if (weapons.size() == 1)
			currentWeapon = weapon;
	}
	
	public int nbWeapon () {
		return weapons.size();
	}
	
	public boolean hasWeapon () {
		return weapons.size() > 0;
	}
	
	public void removeWeapon (Weapon weapon) {
		weapons.remove(weapon);
	}
	
	public void addKey (Key key) {
		keys.add(key);
	}
	
	public int nbKeys () {
		return keys.size();
	}
	
	public boolean hasKey () {
		return keys.size() > 0;
	}
	
	public void removeKey (Key key) {
		keys.remove(key);
	}
	
}
