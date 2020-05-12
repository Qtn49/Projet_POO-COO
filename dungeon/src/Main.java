import model.Game;
import model.Level;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game game = new Game(Level.initLevel1(), true);

		game.start();
		
	}

}
