package model;

public class Wizard extends Enemy {

	/**
	 * 
	 * @param name
	 */
	public Wizard(String name) {
		this(name, 20);
	}
	
	/**
	 * 
	 * @param name
	 * @param music
	 */
	public Wizard(String name, Music music) {
		this(name, 20, music);
	}
	
	/**
	 * @param name
	 * @param maxHealth
	 */
	public Wizard(String name, int maxHealth) {
		this(name, maxHealth, Music.ORC_AND_SWORD);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param name
	 * @param mAX_HEALTH
	 * @param music
	 */
	public Wizard(String name, int mAX_HEALTH, Music music) {
		this(name, mAX_HEALTH, music, Weapon.MAGIC_WAND);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param mAX_HEALTH
	 * @param music
	 * @param weapon
	 */
	public Wizard(String name, int maxHealth, Music music, Weapon weapon) {
		super(name, maxHealth, music, weapon);
	}

	

}
