package model;

import utility.Console;

public abstract class Fighter extends Character {

	private final int MAX_HEALTH;
	private int health;
	private int chance;
	private boolean criticHit;
	private int damage;
	
	/**
	 * @param name
	 * @param location
	 * @param maxHealth
	 * @param health
	 */
	public Fighter(String name, Room location, int maxHealth, Weapon weapon) {
		super(name, location);
		MAX_HEALTH = maxHealth;
		health = maxHealth;
		getEquipment().addWeapon(weapon);
	}



	public int getDamage() {
		
		return damage;
	}
	
	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}



	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}

	/**
	 * @return the criticHit
	 */
	public boolean isCriticHit() {
		return criticHit;
	}

	/**
	 * @param criticHit the criticHit to set
	 */
	public void setCriticHit(boolean criticHit) {
		this.criticHit = criticHit;
	}



	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @param health the health to set
	 */
	public void loseHealth(int points) {
		health -= points;
	}
	
	public void earnHealth (int points) {
		health += points;
		
		if (health > MAX_HEALTH)
			health = MAX_HEALTH;
	}

	/**
	 * @return the alive
	 */
	public boolean isAlive() {
		return health > 0;
	}
	
	public void attack(Fighter fighter) {
		
		damage = getEquipment().getCurrentWeapon().getDamage();
		
		criticHit = Console.getChance(chance);
		
		damage *= criticHit ? 2 : 1;
		
		fighter.loseHealth(damage);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName() + " with his " + getEquipment().getCurrentWeapon();
	}
	
}
