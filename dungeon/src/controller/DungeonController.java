package controller;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import model.Action;
import model.Direction;
import model.Dungeon;
import model.Ennemy;
import model.Game;
import model.Item;
import model.Music;
import model.PlaySound;
import model.Player;
import model.Room;
import model.Statue;
import model.Transition;
import utility.Console;
import view.DungeonView;

public class DungeonController {

//	private static final int MAX_ACTION = 4;
	private Dungeon dungeon;
	private DungeonView view;
	private Game game;
	private PlaySound sound;
	private Player player;
	private Action action;
	private Ennemy ennemy;
	private Item item;
	

	/**
	 * initiate the controller
	 * @param game
	 * @param view
	 */
	public DungeonController(Game game, DungeonView view) {
		super();
		this.game = game;
		this.view = view;
		
		sound = new PlaySound();
		
		dungeon = game.getDungeon();
		player = dungeon.getPlayer();
	}
	
	public void start() {
		sound.setFilepath(player.getCurrentRoom().getMusic().toString());
		sound.play();
		view.start(player, dungeon.getSTATUES_GOAL());
	}
	
	public void playMusic () {
		String filepath = player.getCurrentRoom().getMusic().toString();
		
		sound.setFilepath(filepath);
		
		sound.play();
		
	}
	
	public void describeRoom () {
		
		Room room = player.getCurrentRoom();
		
		view.room(room);
	}
	
	public void checkEnnemy () {
		
		Ennemy ennemy = player.getCurrentRoom().getEnnemy();
		
		if (ennemy != null) {
			view.enemy(ennemy);
			for (Action action : ennemy.getActions()) {
				player.addAction(action);
			}
			
			readActions();
		}
		
	}
	
	public void checkItem () {
		
		Item item = player.getCurrentRoom().getItem();
		
		if (item != null) {
			
			view.item(item);
			
			for (Action action : item.getActions()) {
				player.addAction(action);
			}
		

			readActions();
			
		}
		
	}
	
	public void checkTransitions () {
		
		Room room = player.getCurrentRoom();
		
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
//			fight(ennemy, true);
			break;
		case FLEE:
//			if (Console.chance(20))
//				player.setCurrentRoom(player.getPreviousRoom());
//			else
//				fight(ennemy, false);
			break;
		case TAKE:
			view.take(player.getCurrentRoom().getItem(), player);
			player.takeItem();
			break;
		case LEAVE:
			view.leave();
			break;
			

		default:
			break;
		}
		
	}
	
	public void move (Direction direction) {
		
		sound.stop();
		
		if (player.getCurrentRoom().getTransitions().get(direction).getSound() != null) 			
			player.getCurrentRoom().getTransitions().get(direction).playSound();
		
		view.move(player.getCurrentRoom(), direction);
		
		if (player.getCurrentRoom().getTransitions().get(direction).getSound() != null)
			player.getCurrentRoom().getTransitions().get(direction).stopSound();

		player.move(direction);
		
		sound.setFilepath(player.getCurrentRoom().getMusic().toString());
		sound.play();
		
	}
	
//	public void fight(Ennemy ennemy, boolean playerTurn) {
//		
//		if (!player.isAlive() || !ennemy.isAlive())
//			return;
//		
//		if (playerTurn) {
//		
//			player.attack(ennemy);
//			
//			view.weapon(player.getWeapon());
//			view.attack(player);
//			
//		}else {
//			
//			ennemy.attack(player);
//			
//			view.weapon(ennemy.getWeapon());
//			view.attack(ennemy);
//			
//		}
//		
//		fight(ennemy, !playerTurn);
//		
//	}
	
	public void updateView() {
		describeRoom();
		checkEnnemy();
		if (!player.isAlive())
			return;
		checkItem();
		if (player.getStatues() == dungeon.getSTATUES_GOAL())
			return;
		checkTransitions();
		updateView();
	}
	
}
