import model.Action;
import model.Direction;
import model.Game;
import model.Level;
import model.Music;
import model.PlaySound;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game game = new Game(Level.initLevel1());

		game.start();
		
	}

}
