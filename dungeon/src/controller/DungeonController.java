package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map.Entry;

import model.Action;
import model.Direction;
import model.Dungeon;
import model.Enemy;
import model.Item;
import model.PlaySound;
import model.Player;
import model.Room;
import model.Transition;
import model.Weapon;
import util.Console;
import view.DungeonView;

/**
 * A controller class to manage all the functionnalities of the game
 * @author quentin
 *
 */
public class DungeonController {

//	private static final int MAX_ACTION = 4;
	private Dungeon dungeon;
	private DungeonView view;
	private PlaySound sound;
	private Player player;
	private boolean over;
	private boolean fighting;
	private boolean unlock;

	/**
	 * initiate the controller
	 * @param dungeon
	 * @param view
	 */
	public DungeonController(Dungeon dungeon, DungeonView view) {
		this(dungeon, view, false);
	}

	/**
	 * initiate the controller
	 * @param dungeon
	 * @param view
	 * @param silence
	 */
	public DungeonController(Dungeon dungeon, DungeonView view, boolean silence) {
		super();
		this.view = view;
		sound = new PlaySound(silence);
		this.dungeon = dungeon;
		player = dungeon.getPlayer();
	}
	
	/**
	 * @return the over
	 */
	public boolean isOver() {
		return over;
	}

	/**
	 * @param over : the over to set
	 */
	public void setOver(boolean over) {
		this.over = over;
	}

	/**
	 * method that initiate the game by setting the sound and printing the start view
	 */
	public void start() {
		sound.setFilepath(player.getLocation().getMusic().toString());
		sound.play();
		view.start(player, dungeon.getSTATUES_GOAL());
		updateView();
	}
	
	/**
	 * method to play music
	 */
	public void playMusic () {
		String filepath = player.getLocation().getMusic().toString();
		
		sound.setFilepath(filepath);
		
		sound.play();
		
	}
	
	/**
	 * method that calls the view to describe the current room of the player
	 */
	public void describeRoom () {
		
		Room room = player.getLocation();
		
		view.room(room);
	}
	
	/**
	 * method to check if there's an enemy around
	 */
	public void checkEnnemy () {
		
		Enemy enemy = player.getLocation().getEnemy();
		
		if (enemy != null) {
			
			view.enemy(enemy);
			player.addAction(Action.ATTACK);
			player.addAction(Action.FLEE);
			
			readActions();
		}
		
	}
	
	/**
	 * method to check if there's some items around and ask the player to do an action on them
	 */
	public void checkItems () {
		
		Weapon weapon = player.getLocation().getEquipment().getCurrentWeapon();
		
		if (weapon != null) {
			
			view.takeWeapon();
			
			player.addAction(Action.TAKE);
			
			player.getEquipment().addWeapon(weapon);
			player.getLocation().getEquipment().setCurrentWeapon(null);
			
			readActions();
			
		}
		
		Item item = player.getLocation().getEquipment().getLastItem();
		
		while (item != null) {
			
			player.takeItem(item);
			
			view.item(item);
			
			player.addAction(item.getAction());
			
			if (item == Item.POTION) {
				player.earnHealth(Item.POTION.getPoints());
				player.getEquipment().removeItem(item);
			}
			
			item = player.getLocation().getEquipment().getLastItem();
			
			if (player.getEquipment().nbItems(Item.STATUE) == dungeon.getSTATUES_GOAL()) {
				over = true;
				view.goal(dungeon.getSTATUES_GOAL());
			}
			
			readActions();
			
		}
		
	}
	
	/**
	 * method to check the transitions that the current room offers
	 */
	public void checkTransitions () {
		
		Room room = player.getLocation();
		
		if (room.getTransitions().size() == 0) {
			over = true;
			return;
		}
		
		for (Entry<Direction, Transition> transition : room.getTransitions().entrySet()) {

				view.transition(transition.getKey());
				player.addAction(transition.getKey().getAction());
		}
		
		readActions();
		
	}
	
	/**
	 * method to read an action from the user
	 */
	public void readActions() {
		
		Collection<Action> actions = player.getActions();
		
//		if (actions.size() == 0)
//			throw new NoActionException();
		
		for (Action action : actions) {
			
			view.action(action);
			
			Console.addPattern(action.getAction());
			
		}
		
		Action action = Action.getAction(Console.read(), player.getActions());
		
		System.out.println();
		
		executeAction(action);
		
		if (action == Action.STATS)
			readActions();
		
		player.resetActions();
		
	}
	
	/**
	 * method that executes a given action 
	 * @param action : Action 
	 */
	public void executeAction (Action action) {
		
		switch (action) {
		case NORTH:
			move(Direction.NORTH);
			break;
		case SOUTH:
			move(Direction.SOUTH);
			break;
		case EAST:
			move(Direction.EAST);
			break;
		case WEST:
			move(Direction.WEST);
			break;
		case ATTACK:
			fight(true);
			break;
		case FLEE:
			if (Console.getChance(100)) {
				view.successFlee();
			}else {
				view.failFlee();
				fight(false);
			}
			break;
		case TAKE:
			view.take();
			break;
		case POWERFUL_HIT:
			player.setCriticHit(true);
			break;
		case UNLOCK:
			player.getEquipment().removeItem(Item.KEY);
			view.unlock();
			unlock = true;
			break;
		case STATS:
			view.checkStats(player);
			break;
		case DRINK:
			view.drink(player.getHealth());
		default:
			break;
		}
		
	}
	
	/**
	 * method that list all weapons and ask the user to choose one
	 */
	public void chooseWeapon() {
		
		ArrayList<Weapon> weapons = player.getEquipment().getWeapons();
		
		view.chooseWeapon(weapons);
		
		for (int index = 1; index <= weapons.size(); index++) {
			
			Console.addPattern(java.lang.Character.forDigit(index, 10));
			
		}
		
		player.getEquipment().setCurrentWeapon(weapons.get(Character.getNumericValue(Console.read()) - 1));
		
		System.out.println();
		
	}

	/**
	 * Method to move the player in the given direction, checking whether it's opened and playing the music needed
	 * @param direction : Direction
	 */
	public void move (Direction direction) {
		
		Transition transition = player.getLocation().getTransitions().get(direction);
		
		if (!transition.getRoom().isOpen()) {
			view.locked();
			if (player.getEquipment().hasItem(Item.KEY)) {
				view.hasItem(Item.KEY);
				player.resetActions();
				player.addAction(Action.UNLOCK);
				player.addAction(Action.LEAVE);
				
				readActions();
				
				if (unlock)
					transition.getRoom().setOpen(true);
				else
					return;
			}else
				return;
		}
		
		if (transition.getMusic() != null) {
			sound.stop();
			sound.setFilepath(transition.getMusic().toString());
			sound.play(false);
		}
		
		view.move(player.getLocation(), direction);

		player.move(direction);
		
	
		sound.stop();
		sound.setFilepath(player.getLocation().getMusic().toString());
		sound.play();
		
	}
	
	/**
	 * method called recursively to manage the player fight, from a given boolean if it is the player turn 
	 * @param playerTurn
	 */
	public void fight(boolean playerTurn) {
		
		if (!fighting) {
			chooseWeapon();
			fighting = true;
			view.attack();
			player.resetActions();
			Action powerfulHit = Action.POWERFUL_HIT, hit = Action.HIT;
			powerfulHit.setWeapon(player.getEquipment().getCurrentWeapon());
			powerfulHit.setChance(player.getEquipment().getCurrentWeapon().getChance());
			hit.setWeapon(player.getEquipment().getCurrentWeapon());
			player.addAction(Action.HIT);
			player.addAction(powerfulHit);
		}
		
		Enemy enemy = player.getLocation().getEnemy();
		player.setCriticHit(false);
		
		if (enemy.getMusic() != null && !enemy.getMusic().toString().equals(sound.getFilepath())) {
			sound.stop();
			sound.setFilepath(enemy.getMusic().toString());
			sound.play();
		}
		
		if (!player.isAlive() || !player.getLocation().getEnemy().isAlive()) {
			
			fighting = false;
			
			if (player.isAlive()) {
				view.defeat(player, player.getLocation().getEnemy());
				view.dropped();
				player.getLocation().getEquipment().stealEquipment(enemy.getEquipment());
				player.getLocation().setEnemy(null);
				player.resetHit();
			}else {
				view.defeat(player.getLocation().getEnemy(), player);
				over = true;
			}
			sound.stop();
			sound.setFilepath(player.getLocation().getMusic().toString());
			sound.play();
			return;
		}
		
		view.health(player, player.getLocation().getEnemy());
		
		if (playerTurn) {
			readActions();
			
			player.attack(enemy);
			
			view.attack(player, enemy);
			
		}else {
			Action powerfullHit = Action.POWERFUL_HIT, hit = Action.HIT;
			powerfullHit.setWeapon(player.getEquipment().getCurrentWeapon());
			powerfullHit.setChance(player.getChance());
			hit.setWeapon(player.getEquipment().getCurrentWeapon());
			player.addAction(hit);
			player.addAction(powerfullHit);
			
			enemy.attack(player);
			
			view.attack(enemy, player);
		}
		
		fight(!playerTurn);
		
	}
	
	/**
	 * method called recursively until the game is over to play each action needed
	 */
	public void updateView() {
		describeRoom();
		checkEnnemy();
		if (over)
			return;
		checkItems();
		if (over) {
			sound.stop();
			view.win();
			return;
		}
		checkTransitions();
		updateView();
	}
	
}
