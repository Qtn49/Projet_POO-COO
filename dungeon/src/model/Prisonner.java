package model;
public class Prisonner extends Character {

	private boolean free;
	
	public Prisonner(String name, Room location) {
		super(name, location);
		// TODO Auto-generated constructor stub
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

}