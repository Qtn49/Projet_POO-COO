package model;

public enum Music {

	FIRST_DOOR ("data/sounds/First door.wav"),
	DOOR_OPEN ("data/sounds/Door open.wav"),
	INTRO ("data/sounds/intro.wav"),
	ORC_AND_SWORD ("data/sounds/Orc and sword.wav"),
	STEPS ("data/sounds/Steps.wav"),
	THEME ("data/sounds/theme.wav"),
	DUCK ("data/sounds/annoyingSound.wav"), 
	TOILETS ("data/sounds/toiletFlush.wav"),
	SNORE ("data/sounds/snoring.wav"), 
	COUGH ("data/sounds/cough.wav"), 
	RADIO ("data/sounds/radio.wav"),
	BIRDS ("data/sounds/birds.wav"),
	WATER ("data/sounds/water.wav");
	
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
