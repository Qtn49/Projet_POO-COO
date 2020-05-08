package view;

import java.util.HashMap;
import java.util.Map;

import model.Direction;
import model.Music;
import model.PlaySound;
import model.Room;
import model.Statue;
import utility.Console;

public class DungeonView {

	private PlaySound sound;
	
	/**
	 * initiate the sound
	 */
	public DungeonView() {
		
		sound = new PlaySound();
		
	}
	
	/**
	 * Start the intro of the story for the given statues
	 * @param statues
	 */
	public void start(int statues) {
		// TODO Auto-generated method stub
		
		Console.print("You're the heroic Thorn but right now you're struggling outside...");
		Console.print("In front of you is holding a big dungeon. Yes, that's your goal... The dungeon of Girk !!");
		Console.print("It contains the " + statues + " statues that allow you to accomplish any wish once gathered !");
		Console.print("But you have to be aware of the many dangers that are waiting for you inside...");
		
	}
	
	/**
	 * play the given {@link Music}
	 * if the given music is different, stops the previous one
	 * @param music
	 */
	public void playMusic(Music music) {
		
		if (!music.toString().equals(sound.getFilepath()) && sound.getStatus().equals("play"))
			sound.stop();
		
		if (!music.toString().equals(sound.getFilepath())) {
			sound.setFilepath(music.toString());
			sound.play();
			
		}
	}
	
	/**
	 * stop the current music
	 */
	public void stopMusic() {
		sound.stop();
	}
	
	/**
	 * describe the given room
	 * @param room
	 */
	public void describeRoom (Room room) {
		
		HashMap<Direction, Room> neighbors = room.getNeighbors();
		
		Console.print(room.toString());
		
		for (Direction direction : neighbors.keySet()) {
			
			if (room.getDoor(direction) != null)
				Console.print("To the " + direction + " there is " + room.getDoor(direction));
			
			else if (neighbors.get(direction) != null)
				Console.print("To the " + direction + " there is a room");
			
		}
		
		if (room.getItem() instanceof Statue)
			Console.print("Well done ! You found a Statue !");
		
	}

	/**
	 * Describe all the possible actions of the Player
	 * @param room
	 * @return
	 */
	public String askForAction (Room room) {
		
		HashMap<Direction, Room> neighbors = room.getNeighbors();
		String pattern = "";
		
		for (Direction direction : neighbors.keySet()) {
			
			Console.print("\t(" + direction.getAction() + ") " + direction.getAction().getDescription());
			pattern += direction.getAction();
		}
		
		Console.print("Your choice ?\n=>", false);
		
		return pattern;
		
	}
	
}
