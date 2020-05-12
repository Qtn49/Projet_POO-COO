package model;

public abstract class Character {

	private String name;
	private Equipment equipment;
	private Room location;

	/**
	 * @param name
	 */
	public Character(String name, Room location) {
		super();
		this.name = name;
		this.setLocation(location);
		equipment = new Equipment();
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

	public Room getLocation() {
		return location;
	}

	public void setLocation(Room location) {
		this.location = location;
	}
	
}
