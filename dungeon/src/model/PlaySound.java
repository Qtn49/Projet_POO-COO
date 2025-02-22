package model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * a class used to play a music
 * @author quentin
 *
 */
public class PlaySound {

	private Clip clip;
	private boolean silence;
	private String status;
	private AudioInputStream audioInputStream;
	private String filepath;
	private boolean ready;
	
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

		this(filepath, false);
 
	}
	
	/**
	 * @param silence
	 */
	public PlaySound(boolean silence) {
		this(null, silence);
	}

	/**
	 * @param filepath
	 * @param silence
	 */
	public PlaySound(String filepath, boolean silence) {
		super();
		this.filepath = filepath;
		this.silence = silence;
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
	 * @return the silence
	 */
	public boolean isSilence() {
		return silence;
	}

	/**
	 * @param silence the silence to set
	 */
	public void setSilence(boolean silence) {
		this.silence = silence;
	}

	/**
	 * @return the clip
	 */
	public Clip getClip() {
		return clip;
	}

	/**
	 * @param clip the clip to set
	 */
	public void setClip(Clip clip) {
		this.clip = clip;
	}

	/**
	 * initialize the file path and the music
	 * @throws NoFileException 
	 */
	public void init() {
//		if (filepath == null)
//			throw new NoFileException();
		
		if (silence) {
			ready = false;
			return;
		}
		
		ready = true;
		
		try {

			// create AudioInputStream object 
			audioInputStream = 
					AudioSystem.getAudioInputStream(new File(filepath)); 
			
			// create clip reference 
			clip = AudioSystem.getClip();  
			
			// open audioInputStream to the clip 
			clip.open(audioInputStream);
			
		} catch (Exception e) {
			System.out.println("Couldn't find the sound, sorry");
			System.exit(-1);
		}
		
	}
	
	public void play() {
		play(true);
	}
	
	/**
	 * play the sound
	 * initialize it if it's not
	 */
	public void play(boolean loop) {
		
		if (silence)
			return;
		
		init();
		
		if (!ready)
			return;
			
		if (loop)
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		clip.start();
			
		
		status = "play";
	}
	
	/**
	 * stop the music and close the file
	 */
	public void stop() {
		
		if (silence)
			return;
		
		clip.stop();
		clip.close();
		status = "stop";
	}
	
	/**
	 * 
	 * @return whether a music is currently playing or not
	 */
	public boolean isPlaying() {
		
		return clip.isActive();
	}
	
}
