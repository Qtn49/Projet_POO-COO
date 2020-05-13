package controller;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Stack;

import model.Action;
import model.Direction;
import model.Dungeon;
import model.Enemy;
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
	private Stack<PlaySound> sound;
	private Player player;
	private Action action;
	private boolean silence;
	

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
		this.silence = silence;
		sound = new Stack<PlaySound>();
		sound.push(new PlaySound(silence));
		this.dungeon = dungeon;
		player = dungeon.getPlayer();
	}
	
	public void start() {
		sound.peek().setFilepath(player.getLocation().getMusic().toString());
		sound.peek().play();
		view.start(player, dungeon.getSTATUES_GOAL());
	}
	
	public void playMusic () {
		String filepath = player.getLocation().getMusic().toString();
		
		sound.peek().setFilepath(filepath);
		
		sound.peek().play();
		
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
	
	public void checkStatues () {
		
		if (player.getLocation().getEquipment().hasStatue()) {
		
			player.takeStatue();
			
			view.statue();
			
			player.addAction(Action.TAKE);

			readActions();
			
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
			player.addAction(Action.HIT);
			player.getActions().get(0).setWeapon(player.getEquipment().getCurrentWeapon());
			player.addAction(Action.POWERFUL_HIT);
			fight(true);
			break;
		case FLEE:
			if (Console.getChance(10))
				player.getLocation().setEnemy(null);
			else
				fight(false);
			break;
		case TAKE:
			view.takeStatue(player);
			break;
		case POWERFUL_HIT:
			player.setCriticHit();
			break;
		default:
			break;
		}
		
	}
	
	public void move (Direction direction) {
		
		Transition transition = player.getLocation().getTransitions().get(direction);
		
		sound.push(new PlaySound(transition.getMusic().toString(), silence));
		sound.peek().play();
		
		view.move(player.getLocation(), direction);
		
		sound.pop().stop();

		player.move(direction);
		
		if (!sound.peek().getFilepath().equals(player.getLocation().getMusic().toString())) {
			sound.pop().stop();
			sound.push(new PlaySound(player.getLocation().getMusic().toString()));
			sound.peek().play();
		}
		
	}
	
	public void fight(boolean playerTurn) {
		
		Enemy enemy = player.getLocation().getEnemy();
		
		if (enemy.getMusic() != null && !enemy.getMusic().toString().equals(sound.peek().getFilepath())) {
			sound.pop().stop();
			sound.push(new PlaySound(enemy.getMusic().toString()));
			sound.peek().play();
		}
		
		view.health(player, player.getLocation().getEnemy());
		
		if (playerTurn)
			readActions();
		else {
			player.addAction(Action.HIT);
			player.addAction(Action.POWERFUL_HIT);
			player.getActions().get(1).setChance(player.getChance());
		}
		
		if (!player.isAlive() || !player.getLocation().getEnemy().isAlive()) {
			if (player.isAlive())
				view.defeat(player, player.getLocation().getEnemy());
			else
				view.defeat(player.getLocation().getEnemy(), player);
			sound.pop().stop();
			sound.push(new PlaySound(player.getLocation().getMusic().toString()));
			sound.peek().play();
			return;
		}
		
		if (playerTurn) {
		
			player.attack(enemy);
			
			view.attack(player, enemy);
			
		}else {
			
			enemy.attack(player);
			
			view.attack(enemy, player);
			
		}
		
		fight(!playerTurn);
		
	}
	
	public void updateView() {
		describeRoom();
		checkEnnemy();
		if (!player.isAlive())
			return;
		checkStatues();
		if (player.getEquipment().nbStatues() == dungeon.getSTATUES_GOAL())
			return;
		checkTransitions();
		updateView();
	}
	
}
