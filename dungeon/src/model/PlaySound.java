package model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlaySound {

	private Clip clip;
	
	private String status;
	private AudioInputStream audioInputStream;
	private String filepath;
	
	/**
	 * Initiate a sound with no file path
	 */
	public PlaySound() {

		this(null);
		
	}
	
	/**
	 * initiate a sound with a given file path
	 * @param filepath
	 */
	public PlaySound(String filepath) { 

		super();
		this.filepath = filepath;
		status = "stop";
 
	}
	
	/**
	 * @return the filepath
	 */
	public String getFilepath() {
		return filepath;
	}

	/**
	 * @param filepath the filepath to set
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
		init();
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * initialize the file path and the music
	 * @throws NoFileException 
	 */
	public void init() {
//		if (filepath == null)
//			throw new NoFileException();
		
		try {

			// create AudioInputStream object 
			audioInputStream = 
					AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile()); 
			
			// create clip reference 
			clip = AudioSystem.getClip(); 
			
			// open audioInputStream to the clip 
			clip.open(audioInputStream); 
			
		} catch (Exception e) {
			System.out.println("Erreur du fichier audio");
			System.exit(-1);
		}
		
	}
	
	/**
	 * play the sound
	 * initialize it if it's not
	 */
	public void play() {
		
		
		if (audioInputStream == null)
			init();
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
		
		status = "play";
	}
	
	/**
	 * stop the music and close the file
	 */
	public void stop() {
		clip.stop();
		clip.close();
		status = "stop";
	}
	
}
