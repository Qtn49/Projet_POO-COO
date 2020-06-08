package model;

import util.Console;

/**
 * an abstract class to describe a fighter behavior
 * @author quentin
 *
 */
public abstract class Fighter extends Character {

	private int health;
	private boolean criticHit;
	private int damage;
	
	/**
	 * @param name
	 * @param health
	 * @param chance
	 * @param damage
	 */
	public Fighter(String name, Room location, int health, Weapon weapon) {
		super(name, location);
		this.health = health;
		damage = weapon.getDamage();
		getEquipment().addWeapon(weapon);
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
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * @param health the health to set
	 */
	public void loseHealth(int points) {
		health -= points;
	}
	
	public void earnHealth (int points) {
		health += points;
	}

	/**
	 * @return the alive
	 */
	public boolean isAlive() {
		return health > 0;
	}
	
	/**
	 * the attck method
	 * check if there's a doubling attack
	 * @param fighter
	 */
	public void attack(Fighter fighter) {
		
		damage = getEquipment().getCurrentWeapon().getDamage();
		
		criticHit = Console.getChance(getEquipment().getCurrentWeapon().getChance());
		
		damage *= criticHit ? 2 : 1;
		
		fighter.loseHealth(damage);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName() + " with their " + getEquipment().getCurrentWeapon();
	}
	
}
