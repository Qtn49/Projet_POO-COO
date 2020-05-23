package application;
import javax.xml.bind.JAXBException;

import controller.MenuController;
import model.Menu;
import view.MenuView;

public class Main {

	public static void main(String[] args) throws InterruptedException, JAXBException {
		// TODO Auto-generated method stub
		
		Menu menu = new Menu();
		MenuView menuView = new MenuView();
		MenuController controller = new MenuController(menuView, menu);
		controller.startMenu();
		
//		JAXBContext context = JAXBContext.newInstance(Dungeon.class);
//		Marshaller marshaller = context.createMarshaller();
//		
//		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		
//		Dungeon dungeon = Level.initLevel1();
//		marshaller.marshal(Level.initLevel1(), new File("test.xml"));
		
	}

}
