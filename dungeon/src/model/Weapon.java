package model;

public enum Weapon {
	
	FIST ("own fist", 5, 10),
	MAGIC_WAND ("magic wand", 5, 40),
	MASSUE ("huge massue", 10, 20), 
	FIRE ("fire", 15, 30), 
	AXE ("axe", 20, 5),
	KNIFE ("knife", 10, 10);
	
	private String name;
	private int damage;
	private int chance;

	/**
	 * @param name
	 * @param damage
	 * @param chance
	 */
	private Weapon(String name, int damage, int chance) {
		this.name = name;
		this.damage = damage;
		this.setChance(chance);
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
	 * @return the chance
	 */
	public int getChance() {
		return chance;
	}

	/**
	 * @param chance the chance to set
	 */
	public void setChance(int chance) {
		this.chance = chance;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
}