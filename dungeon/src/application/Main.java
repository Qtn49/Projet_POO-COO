package application;
import controller.MenuController;
import model.Menu;
import view.MenuView;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Menu menu = new Menu();
		MenuView menuView = new MenuView();
		MenuController controller = new MenuController(menuView, menu);
		controller.startMenu();
		
	}

}
