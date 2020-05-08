package model;

public enum Music {

	FIRST_DOOR ("sounds/First door.wav"),
	DOOR_OPEN ("sounds/Door open.wav"),
	INTRO ("sounds/intro.wav"),
	ORC_AND_SWORD ("sounds/Orc and sword.wav"),
	STEPS ("sounds/Steps.wav"),
	THEME ("sounds/theme.wav"),
	TEST ("sounds/annoyingSound.wav");
	
	private String filepath;
	
	/**
	 * take a file path as a {@link String}
	 * @param filepath
	 */
	Music (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * @return the filepath
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return filepath;
	}
	
}
