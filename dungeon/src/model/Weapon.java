package model;

public enum Weapon {
	
	FIST ("own fist", 5),
	MAGIC_WAND ("magic wand", 10);
	
	private String name;
	private int damage;
	
	private Weapon(String name, int damage) {
		this.name = name;
		this.damage = damage;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
}