package view;

import java.util.HashMap;
import java.util.Map;

import model.Console;
import model.Direction;
import model.Music;
import model.PlaySound;
import model.Room;

public class DungeonView {

	private PlaySound sound;
	
	public void start() {
		// TODO Auto-generated method stub
		
		Console.print("You're the heroic Thorn but right now you're struggling outside...");
		Console.print("In front of you is holding a big dungeon. Yes, that's your goal... The dungeon of Girk !!");
		Console.print("It contains the four statues that allow you to accomplish any wish once gathered !");
		Console.print("But you have to be aware of the many dangers that are waiting for you inside...");
		
		
	}
	
	public void playMusic(Music music) {
		sound = new PlaySound(music);
		sound.play();
	}
	
	public void stopMusic() {
		sound.stop();
	}
	
	public void printNeighbors (Room room) {
		
		HashMap<Direction, Room> neighbors = room.getNeighbors();
		
		Console.print(room.toString());
		
		if (neighbors.size() == 0)
			Console.print("You're stuck ! Well done !");
		
		for (Direction direction : neighbors.keySet()) {
			
			if (room.getDoor(direction) != null)
				Console.print("To the " + direction + " there is " + room.getDoor(direction));
			
			else if (neighbors.get(direction) != null)
				Console.print("To the " + direction + " there is a room");
			
		}
		
	}

	public String askForAction (Room room) {
		
		HashMap<Direction, Room> neighbors = room.getNeighbors();
		String pattern = "";
		
		for (Direction direction : neighbors.keySet()) {
			
			Console.print("\t(" + direction.getNickname() + ") to go to the " + direction);
			pattern += direction.getNickname();
		}
		
		Console.print("Your choice ?\n=>", false);
		
		return pattern;
		
	}
	
}
