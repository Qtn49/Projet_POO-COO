package model;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum Music {

	FIRST_DOOR ("Resources/sounds/First door.wav"),
	DOOR_OPEN ("Resources/sounds/Door open.wav"),
	INTRO ("Resources/sounds/intro.wav"),
	ORC_AND_SWORD ("Resources/sounds/Orc and sword.wav"),
	STEPS ("Resources/sounds/Steps.wav"),
	THEME ("Resources/sounds/theme.wav"),
	DUCK ("Resources/sounds/annoyingSound.wav"), 
	TOILETS ("Resources/sounds/toiletFlush.wav"),
	SNORE ("Resources/sounds/snoring.wav"), 
	COUGH ("Resources/sounds/cough.wav"), 
	RADIO ("Resources/sounds/radio.wav"),
	BIRDS ("Resources/sounds/birds.wav"),
	WATER ("Resources/sounds/water.wav");
	
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
