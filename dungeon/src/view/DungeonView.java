package view;

import java.util.ArrayList;

import model.Action;
import model.Direction;
import model.Enemy;
import model.Equipment;
import model.Fighter;
import model.Item;
import model.Player;
import model.Room;
import model.Weapon;
import util.Console;

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
		System.out.println();
		
	}

	public void room(Room room) {
		
		Console.print(room.toString());
		System.out.println();
		
	}

	public void action(Action action) {

		Console.print("\t(" + action + ") " + action.getDescription());
		
	}

	public void move(Room room, Direction direction) {
		
		Console.print(room.getTransitions().get(direction).toString());
		System.out.println();
		
	}

	public void transition(Direction direction) {
		
		Console.print("There is a door to the " + direction);
		
	}

	public void enemy(Enemy ennemy) {
		
		Console.print("Hummm, seems like there is an ennemy...");
		Console.print(ennemy);
		
	}

	public void takeStatue (Player player) {
	
		switch (player.getEquipment().nbItems(Item.STATUE)) {
			case 1:
				Console.print("Well done ! You just found your first " + Item.STATUE);
				break;
			default:
				Console.print("And one more statue for " + player.getName());
				break;
		}

		System.out.println();
		
	}
	
	public void health(Player player, Enemy enemy) {
		
		Console.print("You have " + player.getHealth() + " health points and " + enemy.getName() + " has " + enemy.getHealth() + " health points");
		
	}

	public void attack(Fighter attacker, Fighter defender) {

		boolean player = false;
		
		if (attacker instanceof Player)
			player = true;
		
		if (attacker.getDamage() == attacker.getEquipment().getCurrentWeapon().getDamage() * 2) {
			if (player)
				Console.print(attacker.getDamage() > 0 ? "Lucky you ! You just had your best shot on this one" : "Ohhh nahhh ! You just missed it !");
			else
				Console.print("Critic shot from " + attacker.getName());
		}
		
		if (attacker.getDamage() > 0)
			Console.print((player ? "You give " + defender.getName() : attacker.getName() + " gives you") +  " a " + attacker.getDamage() + " points attack");
		
		System.out.println();
		
	}
	
	public void defeat (Fighter winner, Fighter loser) {
		
		if (winner instanceof Player)
			Console.print("Well done ! You defeated the terrible " + loser.getName());
		else
			Console.print("Oh nahhhh you just died under the attacks of " + winner.getName());
		
		System.out.println();
		
	}

	public void statue() {
		
		Console.print("Oh ! There's a statue here !");
		
	}

	public void attack() {

		Console.print("You decide to attack and manage to attack him first");
		System.out.println();
		
	}

	public void successFlee() {
		
		Console.print("You successfully escaped ! The ennemy is now gone !");
		System.out.println();
		
	}

	public void failFlee() {
		
		Console.print("Oh noooo... You couldn't escaped and the enemy found you back !");
		System.out.println();
		
	}

	public void item(Item item) {
		
		Console.print("Well ! You just found a " + item + " !");
		
	}

	public void take() {
		
		Console.print("Yessir, you're filling your equipment pretty well");
		System.out.println();
		
	}
	
	public void locked () {
		
		Console.print("Huh ! Seems like this door is locked... You might need a key for that one");
		System.out.println();
		
	}

	public void goal(int statues_GOAL) {

		Console.print("Well done dude ! You just found all of the " + statues_GOAL + Item.STATUE);
		System.out.println();

	}

	public void unlock() {

		Console.print("Yess the door is now unlocked ! But unfortunately, your key has lost its power... \nYou can't use it anymore...");
		System.out.println();
		
	}

	public void hasItem(Item item) {
		
		Console.print("Well nice ! It seems like you got a " + item);
		
	}

	public void dropped() {
		
		Console.print("Hmmm interesting, seems like the enemy just dropped some stuff...");
		System.out.println();
	}

	public void chooseWeapon(ArrayList<Weapon> weapons) {

		int i = 1;
		
		Console.print("Please choose a weapon from below");
		
		for (Weapon weapon : weapons) {
			
			Console.print("\t(" + i + ") " + weapon.getName() + " " + weapon.getDamage() + " damages (" + weapon.getChance() + "% chance of doubling)");
			i++;
			
		}
		
	}

	public void checkStats(Player player) {
		
		Console.print("You're " + player.getName() + " and right now, you have " + player.getHealth() + " life points left.\n");
		
		Equipment equipment = player.getEquipment();
		
		Console.print("You are armed with ");
		
		for (Weapon weapon : equipment.getWeapons()) {
			
			Console.print("\t- " + weapon.getName() + " with " + weapon.getDamage() + " damages and " + weapon.getChance() + " % chance of doubling");
			
		}
		
		Console.print();
		
		for (Item item : Item.values()) {
			
			if (!equipment.hasItem(item)) {
				Console.print("You don't have any " + item.getName() + " !");
				continue;
			}
			
			Console.print("Right now, you have " + equipment.nbItems(item) + " " + item.getName());
			
		}
		
		System.out.println();
		
	}

	public void takeWeapon() {

		Console.print("There's a weapon here !");
		
	}

	public void drink(int health) {

		Console.print("Glooooop, you just drank the best red bull ever !! You're feeling wayy better and now have " + health + " health points !");
		System.out.println();
		
	}
	
}
