import model.Console;
import model.Direction;
import model.Door;
import model.Dungeon;
import model.Game;
import model.Room;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Room r = new Room("You're outside. There's nothing around nor anybody.");
		Room r1 = new Room("kitchen");
		Room r2 = new Room("living room");
		Room r3 = new Room("You're in the King's bedroom. There's a huge bed in front of you and a tiny one on your left");
		
		Dungeon dungeon = new Dungeon(r);

		r.setDoor(Direction.EAST, new Door("a huge door protected by a mysterious spell"));
		dungeon.getStart().setNeighbors(Direction.EAST, r3, false);
		
		Game game = new Game(dungeon);
				
		game.start();
		
		
	}

}
