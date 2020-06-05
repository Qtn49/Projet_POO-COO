package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * a class that represents a transition element
 * @author quentin
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Room.class, Music.class})
public class Transition {

	@XmlElement
	private String description;
	@XmlElement
	private Music music;
	@XmlElement
	private Room room;
	
	public Transition() {
		// TODO Auto-generated constructor stub
	}
	
	public Transition(String description, Room room) {
		this(description, room, null);
	}
	
	/**
	 * 
	 * @param description
	 * @param room
	 * @param music
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