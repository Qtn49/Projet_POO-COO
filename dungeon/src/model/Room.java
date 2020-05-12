package model;
import java.util.*;

public class Room {

	private String description;
	private Enemy enemy;
	private HashMap<Direction, Transition> transitions;
	private Music music;
	private boolean open;
	private Equipment equipment;

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
		equipment = new Equipment();
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
	 * @return the ennemy
	 */
	public Enemy getEnemy() {
		return enemy;
	}

	/**
	 * @param ennemy the ennemy to set
	 */
	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
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
	
	/**
	 * @return the equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}

	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
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