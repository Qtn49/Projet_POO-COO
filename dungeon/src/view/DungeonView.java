package view;

import java.util.HashMap;
import java.util.Map;

import model.Console;
import model.Dungeon;
import model.Room;

public class DungeonView {
	
	public void printRoomDescription (Room room) {
		Console.print(room.toString());
	}

	@Override
	public String toString() {
		return "Hi welcome to the dungeon";
	}

	public void start() {
		// TODO Auto-generated method stub
		
		Console.print("Hi thorn. Now the time has come for you to fetch all the statues of the youth.");
		Console.print("You will finally get your parents together and with you.");
		Console.print("But before that, you need to get through the terrible dungeon of Girk !");
		
	}
	
	public void printNeighbors (Room room) {
		
		HashMap<String, Room> neighbors = room.getNeighbors();
		
		printRoomDescription(room);
		
		for (Map.Entry<String, Room> entry : neighbors.entrySet()) {
			
			String direction = entry.getKey();
			Room neighbor = entry.getValue();
			
			if (neighbor != null) {
				Console.print("To the " + direction + " I have the " + neighbor.getName() + " room");
			}
			
		}
		
	}
	
}
