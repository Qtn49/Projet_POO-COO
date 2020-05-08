package model;
public class Door {

	private DoorState state;
	private String description;
	
	
	
	/**
	 * @param description
	 */
	public Door(String description) {
		this(DoorState.OPEN, description);
	}
	
	/**
	 * @param state
	 * @param description
	 */
	public Door(DoorState state, String description) {
		super();
		this.state = state;
		this.description = description;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return description;
	}

}