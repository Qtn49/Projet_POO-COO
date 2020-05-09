package model;
import java.util.*;

public class Room {

	private Item item;
	private String description;
	private Ennemy ennemy;
	private HashMap<Direction, Transition> transitions;
	private Music music;
	private boolean open;

	/**
	 * Initiate a room with a default music
	 * @param description
	 */
	public Room(String description) {
		this(description, Music.THEME);
	}

	/**
	 * initiate a room with a given music
	 * @param description
	 * @param music
	 */
	public Room(String description, Music music) {
		super();
		this.description = description;
		this.music = music;
		open = true;
		transitions = new HashMap<Direction, Transition>();
	}

	/**
	 * 
	 * @return the description
	 */
	public String getName() {
		return this.description;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {

		this.description = name;
		
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @return the ennemy
	 */
	public Ennemy getEnnemy() {
		return ennemy;
	}

	/**
	 * @param ennemy the ennemy to set
	 */
	public void setEnnemy(Ennemy ennemy) {
		this.ennemy = ennemy;
	}

	/**
	 * @return the open
	 */
	public boolean isOpen() {
		return open;
	}

	/**
	 * @param open the open to set
	 */
	public void setOpen(boolean open) {
		this.open = open;
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
	
	public HashMap<Direction, Transition> getTransitions() {
		return transitions;
	}
	
	/**
	 * set a unique transition
	 * @param direction
	 * @param transition
	 * @param room
	 */
	public void setTransition(Direction direction, Transition transition) {
		setTransition(direction, transition, false);
	}

	/**
	 * set a new transition
	 * @param direction
	 * @param transition
	 * @param room
	 * @param bothside
	 */
	public void setTransition(Direction direction, Transition transition, boolean bothside) {
		transitions.put(direction, transition);
//		neighbors.put(direction, room);
		if (bothside) {
			Room room = transition.getRoom();
			Transition opposedTransition = new Transition(transition);
			opposedTransition.setRoom(this);
			room.setTransition(direction.opposedDirection(), opposedTransition);
		}
	}

	/**
	 * @return the description of the room
	 */
	@Override
	public String toString() {
		return description;
	}

}