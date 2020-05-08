package model;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.audio.AudioPlayer;

public class PlaySound {

	private Clip clip;
	
	String status;
	AudioInputStream audioInputStream;
	
	public PlaySound(Music filepath) {
		this(filepath.toString());
	}
	
	public PlaySound(String filepath) { 
		try {

			// create AudioInputStream object 
			audioInputStream = 
					AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile()); 
			
			// create clip reference 
			clip = AudioSystem.getClip(); 
			
			// open audioInputStream to the clip 
			clip.open(audioInputStream); 
			
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			
		} catch (Exception e) {
			System.out.println("Erreur du fichier audio");
			System.exit(-1);
		}
 
	}
	
	public void play() {
		clip.start();
		
		status = "play";
	}
	
	public void stop() {
		clip.stop();
		clip.close();
	}
	
}
