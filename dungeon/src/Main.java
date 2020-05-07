import controller.DungeonController;
import model.Dungeon;
import model.Game;
import model.Room;
import view.DungeonView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dungeon dungeon = new Dungeon(new Room("main"));
		
		dungeon.getStart().setEast(new Room("kitchen"));
		dungeon.getStart().setNorth(new Room("nothing"));
		dungeon.getStart().setSouth(new Room("playground"));
		
		Game game = new Game(dungeon);
		
		game.start();
		game.getController().getNeighbors();
		
	}

}
