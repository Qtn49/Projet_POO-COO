package view;

import model.Action;
import model.Direction;
import model.Enemy;
import model.Fighter;
import model.Player;
import model.Room;
import utility.Console;

public class DungeonView {

	
	/**
	 * initiate the sound
	 */
	public DungeonView() {
				
	}
	
	/**
	 * Start the intro of the story for the given statues
	 * @param statues
	 */
	public void start(Player player, int statues) {
		
		Console.print("You're the heroic " + player.getName() + " but right now you're struggling outside...");
		Console.print("In front of you is holding a big dungeon. Yes, that's your goal... The dungeon of Girk !!");
		Console.print("It contains the " + statues + " statues that allow you to accomplish any wish once gathered !");
		Console.print("But you have to be aware of the many dangers that are waiting for you inside...");
		Console.print("");
		
	}

	public void room(Room room) {
		
		Console.print(room.toString());
		Console.print();
		
	}

	public void action(Action action) {

		Console.print("\t(" + action + ") " + action.getDescription());
		
	}

	public void move(Room room, Direction direction) {
		
		Console.print(room.getTransitions().get(direction).toString());
		Console.print();
		
	}

	public void transition(Direction direction) {
		
		Console.print("There is a door to the " + direction);
		
	}

	public void enemy(Enemy ennemy) {
		
		Console.print("Hummm, seems like there is an ennemy...");
		Console.print(ennemy);
		
	}

	public void takeStatue (Player player) {
	
		switch (player.getEquipment().nbStatues()) {
			case 0:
				Console.print("Well done ! You just found your first " + player.getEquipment().getLastStatue().getName());
				break;
			default:
				Console.print("And one more statue for " + player.getName());
				break;
		}
			
		
	}

	public void attack(Fighter attacker, Fighter defender) {

		boolean player = false;
		
		if (attacker instanceof Player)
			player = true;
		
		Console.print((player ? "You have " : attacker.getName() + " has ") + attacker.getHealth() + " health points and attacks " + (player ? defender.getName() : "you") + " with " + (player ? "your " : "his ") + attacker.getEquipment().getCurrentWeapon() + "(" + attacker.getEquipment().getCurrentWeapon().getDamage() + " damages)");
		
		if (attacker.isCriticHit()) {
			Console.print("Critic shot !");
		}
		
		Console.print((player ? "You give " + defender.getName() : attacker.getName() + " gives you ") +  "a " + attacker.getDamage() + " points attack");
		
		Console.print();
		
	}
	
	public void defeat (Fighter winner, Fighter loser) {
		
		if (winner instanceof Player)
			Console.print("Well done ! You defeated the terrible " + loser.getName());
		else
			Console.print("Oh nahhhh you just died under the attacks of " + winner.getName());
		
		Console.print();
		
	}
	
}
