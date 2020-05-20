package model;

public enum Music {

	FIRST_DOOR ("/ressources/sounds/First door.wav"),
	DOOR_OPEN ("/ressources/sounds/Door open.wav"),
	INTRO ("/ressources/sounds/intro.wav"),
	ORC_AND_SWORD ("/ressources/sounds/Orc and sword.wav"),
	STEPS ("/ressources/sounds/Steps.wav"),
	THEME ("/ressources/sounds/theme.wav"),
	DUCK ("/ressources/sounds/annoyingSound.wav"), 
	TOILETS ("/ressources/sounds/toiletFlush.wav"),
	SNORE ("/ressources/sounds/snoring.wav"), 
	COUGH ("/ressources/sounds/cough.wav"), 
	RADIO ("/ressources/sounds/radio.wav"),
	BIRDS ("/ressources/sounds/birds.wav"),
	WATER ("/ressources/sounds/water.wav");
	
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
