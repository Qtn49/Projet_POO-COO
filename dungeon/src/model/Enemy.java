package model;

/**
 * abstract class that represents an Enemy and extends Fighter
 * It has a music to play the battle against
 * @author quentin
 *
 */
public class Enemy extends Fighter {
	
	private Music music;
	
	

	/**
	 * @param name
	 * @param health
	 * @param weapon
	 */
	public Enemy(String name, int health, Weapon weapon) {
		this(name, null, health, weapon, Music.ORC_AND_SWORD);
	}
	
	/**
	 * @param name
	 * @param health
	 * @param weapon
	 * @param music
	 */
	public Enemy(String name, int health, Weapon weapon, Music music) {
		this(name, null, health, weapon, music);
	}

	/**
	 * @param name
	 * @param health
	 * @param weapon
	 * @param music
	 */
	public Enemy(String name, Room location, int health, Weapon weapon, Music music) {
		super(name, location, health, weapon);
		this.music = music;
	}

	/**
	 * @return the music
	 */
	public Music getMusic() {
		return music;
	}

	/**
	 * @param music the music to set
	 */
	public void setMusic(Music music) {
		this.music = music;
	}

}