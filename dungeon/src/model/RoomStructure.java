package model;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * deprecated
 * was originally planned to be used to help mapping a level into an xml file
 * @author quentin
 *
 */
@XmlRootElement
@XmlSeeAlso({Room.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomStructure {

	private HashMap<String, Room> rooms;

	public RoomStructure() {
		rooms = new HashMap<>();
	}
	
	/**
	 * @return the rooms
	 */
	public HashMap<String, Room> getRooms() {
		return rooms;
	}

	public void add (String nom, Room room) {
		rooms.put(nom, room);
	}
	
	
	
}
