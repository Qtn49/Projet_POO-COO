package controller;

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
import utility.Console;
import view.DungeonView;

public class DungeonController {

//	private static final int MAX_ACTION = 4;
	private Dungeon dungeon;
	private DungeonView view;
	private PlaySound sound;
	private Player player;
	private Action action;
	private boolean over;

	/**
	 * @param dungeon
	 * @param view
	 */
	public DungeonController(Dungeon dungeon, DungeonView view) {
		this(dungeon, view, false);
	}

	/**
	 * initiate the controller
	 * @param game
	 * @param view
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
	 * @param over the over to set
	 */
	public void setOver(boolean over) {
		this.over = over;
	}

	public void start() {
		sound.setFilepath(player.getLocation().getMusic().toString());
		sound.play();
		view.start(player, dungeon.getSTATUES_GOAL());
	}
	
	public void playMusic () {
		String filepath = player.getLocation().getMusic().toString();
		
		sound.setFilepath(filepath);
		
		sound.play();
		
	}
	
	public void describeRoom () {
		
		Room room = player.getLocation();
		
		view.room(room);
	}
	
	public void checkEnnemy () {
		
		Enemy enemy = player.getLocation().getEnemy();
		
		if (enemy != null) {
			
			view.enemy(enemy);
			player.addAction(Action.ATTACK);
			player.addAction(Action.FLEE);
			
			readActions();
		}
		
	}
	
	public void checkItems () {
		
		Item item = player.getLocation().getEquipment().getLastItem();
		
		while (item != null) {
			
			player.takeItem(item);
			
			view.item(item);
			
			player.addAction(item.getAction());
			
			readActions();
			
			if (item == Item.POTION)
				player.earnHealth(Item.POTION.getPoints());
			
			item = player.getLocation().getEquipment().getLastItem();
			
			if (player.getEquipment().nbItems(Item.STATUE) == dungeon.getSTATUES_GOAL()) {
				over = true;
				view.goal(dungeon.getSTATUES_GOAL());
			}
			
		}
		
	}
	
	public void checkTransitions () {
		
		Room room = player.getLocation();
		
		for (Entry<Direction, Transition> transition : room.getTransitions().entrySet()) {

				view.transition(transition.getKey());
				player.addAction(transition.getKey().getAction());
		}
		
		readActions();
		
	}
	
	public void readActions() {
		
		Collection<Action> actions = player.getActions();
		
//		if (actions.size() == 0)
//			throw new NoActionException();
		
		for (Action action : actions) {
			
			view.action(action);
			
			Console.addPattern(action.getAction());
			
		}
		
		player.resetActions();
		action = Action.getAction(Console.read());
		
		System.out.println();
		
		executeAction();
		
	}
	
	public void executeAction () {
		
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
			view.attack();
			player.addAction(Action.HIT);
			player.getActions().get(0).setWeapon(player.getEquipment().getCurrentWeapon());
			player.addAction(Action.POWERFUL_HIT);
			fight(true);
			break;
		case FLEE:
			if (Console.getChance(10)) {
				view.successFlee();
			}else {
				view.failFlee();
				fight(false);
			}
			break;
		case TAKE:
			view.takeItem(player);
			break;
		case POWERFUL_HIT:
			player.setCriticHit(true);
			player.resetHit();
			break;
		case UNLOCK:
			player.getEquipment().removeItem(Item.KEY);
			view.unlock();
			player.getLocation().setOpen(true);
			break;
		default:
			break;
		}
		
	}
	
	public void move (Direction direction) {
		
		Transition transition = player.getLocation().getTransitions().get(direction);
		
		if (!transition.getRoom().isOpen()) {
			view.locked();
			if (player.getEquipment().hasKey()) {
				view.hasItem(Item.KEY);
				player.addAction(Action.UNLOCK);
				readActions();
			}else
				checkTransitions();
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
	
	public void fight(boolean playerTurn) {
		
		Enemy enemy = player.getLocation().getEnemy();
		player.setCriticHit(false);
		
		if (enemy.getMusic() != null && !enemy.getMusic().toString().equals(sound.getFilepath())) {
			sound.stop();
			sound.setFilepath(enemy.getMusic().toString());
			sound.play();
		}
		
		if (!player.isAlive() || !player.getLocation().getEnemy().isAlive()) {
			if (player.isAlive()) {
				if (enemy.getEquipment().nbItems() > 0) {
					view.dropped();
					player.getLocation().getEquipment().stealEquipment(enemy.getEquipment());
				}
				view.defeat(player, player.getLocation().getEnemy());
				player.getLocation().setEnemy(null);
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
			player.addAction(Action.HIT);
			player.addAction(Action.POWERFUL_HIT);
			player.getActions().get(1).setChance(player.getChance());
			
			enemy.attack(player);
			
			view.attack(enemy, player);
		}
		
		fight(!playerTurn);
		
	}
	
	public void updateView() {
		describeRoom();
		checkEnnemy();
		if (over)
			return;
		checkItems();
		if (over)
			return;
		checkTransitions();
		updateView();
	}
	
}
