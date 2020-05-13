package application;
import model.Game;
import model.Level;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Game game = new Game(Level.initLevel1(), false);

		game.start();
		
	}

}
