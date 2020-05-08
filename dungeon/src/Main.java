import model.Direction;
import model.Door;
import model.Dungeon;
import model.Game;
import model.Music;
import model.Room;
import model.Statue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dungeon dungeon = new Dungeon(new Room("You're outside. There's nothing around nor anybody."));
		
		Room r1 = new Room("You're in the King's bedroom. There's a huge bed in front of you and a tiny one on your left");

		r1.setItem(new Statue());
		r1.setMusic(Music.THEME);
		
		dungeon.getStart().setMusic(Music.INTRO);
		dungeon.getStart().setDoor(Direction.EAST, new Door("a huge door protected by a mysterious spell"));
		dungeon.getStart().setNeighbors(Direction.EAST, r1, false);
		
		Game game = new Game(dungeon, 1);
				
		game.start();
		
		
	}

}
