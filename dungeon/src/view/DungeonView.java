package view;

import model.Action;
import model.Character;
import model.Direction;
import model.Ennemy;
import model.Item;
import model.PlaySound;
import model.Player;
import model.Room;
import model.Statue;
import model.Transition;
import utility.Console;

public class DungeonView {

	private PlaySound sound;
	
	/**
	 * initiate the sound
	 */
	public DungeonView() {
		
		sound = new PlaySound();
		
	}
	
	/**
	 * Start the intro of the story for the given statues
	 * @param statues
	 */
	public void start(Player player, int statues) {
		// TODO Auto-generated method stub
		
		Console.print("You're the heroic " + player.getName() + " but right now you're struggling outside...");
		Console.print("In front of you is holding a big dungeon. Yes, that's your goal... The dungeon of Girk !!");
		Console.print("It contains the " + statues + " statues that allow you to accomplish any wish once gathered !");
		Console.print("But you have to be aware of the many dangers that are waiting for you inside...");
		
	}

	public void room(Room room) {
		// TODO Auto-generated method stub
		
		Console.print(room.toString());
		
	}

	public void character(Character character) {
		
		Console.print("There's " + character.toString());
		
	}

	public void action(Action action) {

		Console.print("\t(" + action + ") " + action.getDescription());
		
	}

	public void move(Room room, Direction direction) {
		
		Console.print(room.getTransitions().get(direction).toString());
		
	}

	public void item(Item item) {

		Console.print("Oh ! You just found an item and it is a " + item);

	}

	public void transition(Direction direction) {
		
		Console.print("There is a door to the " + direction);
		
	}

	public void enemy(Ennemy ennemy) {
		
		Console.print("Hummm, seems like there is an ennemy...");
		Console.print(ennemy);
		
	}

	public void take(Item item, Player player) {
		
		if (item instanceof Statue) {
			switch (player.getStatues()) {
			case 0:
				Console.print("Well done ! You just found your first " + item.getName());
				break;
			default:
				Console.print("And one more statue for " + player.getName());
				break;
			}
		}
			
		
	}

	public void leave() {

		Console.print("You don't find it really interesting anyway, and you just leave it there");
		
	}
	
}
