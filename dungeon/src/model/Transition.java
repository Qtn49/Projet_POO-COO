package model;

public class Transition {

	private String description;
	private Music music;
	private Room room;
	
	public Transition(String description, Room room) {
		this(description, room, null);
	}
	
	/**
	 * 
	 * @param description
	 * @param room
	 * @param music
	 * @param enterMusic
	 */
	public Transition(String description, Room room, Music music) {
		this.description = description;
		this.music = music;
		this.room = room;
	}

	public Transition(Transition transition) {
		this(transition.description, transition.room, transition.music);
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
	
	@Override
	public String toString() {
		return description;
	}

}