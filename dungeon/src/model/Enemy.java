package model;

public abstract class Enemy extends Fighter {
	
	private Music music;
	
	/**
	 * @param name
	 * @param location
	 * @param mAX_HEALTH
	 * @param music
	 */
	public Enemy(String name, int mAX_HEALTH, Music music, Weapon weapon) {
		super(name, null, mAX_HEALTH, weapon);
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