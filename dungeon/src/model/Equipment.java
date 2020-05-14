package model;

import java.util.ArrayList;

public class Equipment {

	private ArrayList<Weapon> weapons;
	private ArrayList<Item> items;
	private Weapon currentWeapon;
	
	public Equipment () {
		weapons = new ArrayList<Weapon>();
		items = new ArrayList<Item>();
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
	public ArrayList<Item> getItems() {
		return items;
	}

	public void addItem (Item item) {
		
		items.add(item);
		
	}
	
	public boolean hasStatue () {
		return nbItems(Item.STATUE) > 0;
	}
	
	public Item removeStatue () {
		for (Item item : items) {
			if (item == Item.STATUE)
				return item;
		}
		
		return null;
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
	
	public int nbItems (Item item) {
		int n = 0;
		
		for (Item i : items) {
			if (i == item)
				n++;
		}
		
		return n;
	}
	
	public boolean hasKey () {
		return nbItems(Item.KEY) > 0;
	}
	
	public Item getLastItem () {
		
		if (items.size() > 0)
			return items.get(items.size() - 1);
		
		return null;
	}

	public Item removeItem(Item item) {
		
		return items.remove(item) ? item : null;
	}
	
	public void stealEquipment (Equipment equipment) {
		
		for (Item item : equipment.items) {
			items.add(equipment.removeItem(item));
		}
		
	}
	
}
