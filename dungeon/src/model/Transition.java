package model;

public class Transition {

	private String description;
	private PlaySound sound;
	private Music music;
	private Room room;
	
	public Transition(String description, Room room) {
		this(description, room, null);
	}
	
	/**
	 * @param access
	 */
	public Transition(String description, Room room, Music music) {
		this.description = description;
		this.music = music;
		this.room = room;
		if (music != null)
			sound = new PlaySound(music.toString());
	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * @return the sound
	 */
	public PlaySound getSound() {
		return sound;
	}

	/**
	 * @param sound the sound to set
	 */
	public void setSound(PlaySound sound) {
		this.sound = sound;
	}

	public void playSound() {
		if (sound != null) {
			sound.setFilepath(music.toString());
			sound.play();
		}
	}
	
	public void stopSound() {
		if (sound != null)
			sound.stop();
	}
	
	@Override
	public String toString() {
		return description;
	}

}