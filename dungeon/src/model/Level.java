package model;

public class Level {

	public static Dungeon initLevel1 () {
		
		Dungeon dungeon = new Dungeon(new Room("You're outside. There's nothing around nor anybody.", Music.INTRO));
		
		Room r1 = new Room("You're in the King's bedroom. There's a huge bed in front of you and a tiny one on your left");
		Room r2 = new Room("You arrived in a silenced room. There's nothing in it... Weird.");
		Room r3 = new Room("You just got into a messy room. There are brooms, buckets, pencils, paint scattered everywhere. \nSeems like an artist was there.");
		Room r4 = new Room("There's an ennemy standing right in front of you ! He is staring at you savagely. \nFortunately for you, it was a statue !");
		Room r5 = new Room("You're right next to a fight. Please be careful !", Music.ORC_AND_SWORD);
		Room r6 = new Room("Wow you just jumped on your feet ! There's literally a duck sitting right next to you", Music.DUCK);
		Room r7 = new Room("Errr you just arrived in the toilets !", Music.TOILETS);
		Room r8 = new Room("I think somebody's sleeping there...", Music.SNORE);
		Room r9 = new Room("OHH be careful I think somebody's sick around...", Music.COUGH);
		Room r10 = new Room("Huh shame, there's nothing here dude.");
		
		Transition t1 = new Transition("You're slowly opening a huuuuuge door and carefully you start seeing the inside... \nThere are bats flying around and someone's roaring", r1, Music.FIRST_DOOR);
		Transition t2 = new Transition("There's a radio playing in this corridor. Nice music mate. You're sitting a moment to listen to it and appreciate the music", r2, Music.RADIO);
		Transition t3 = new Transition("You're opening the door carefully...", r3, Music.DOOR_OPEN);
		Transition t4 = new Transition("You're walking through a corridor and you hear some bird noises. \nOh there they are ! A nest ! \nAmazing !", r4, Music.BIRDS);
		Transition t5 = new Transition("Nice, there's a fountain here. The sound of it is really relaxing", r6, Music.WATER);
		Transition t6 = new Transition("You're taking the stairs. Those are big stairs and you have to climb them up for a while... \\nAfter over 100 steps, you finally get to the room.", r5, Music.STEPS);
		Transition t7 = new Transition("You're moving to the next room...", r6);
		Transition t8 = new Transition("You're moving to the next room", r7);
		Transition t9 = new Transition("You're moving to the next room", dungeon.getStart());
		Transition t10 = new Transition("You're moving to the next room", r8);
		Transition t11 = new Transition("You're moving to the next room", r9);
		Transition t12 = new Transition("You're moving to the next room", r10);

		r1.setEnemy(new Wizard("Gandalf"));
		
		r1.getEquipment().addItem(Item.KEY);
		r3.getEquipment().addItem(Item.STATUE);
		r5.getEquipment().addItem(Item.STATUE);
		r7.getEquipment().addItem(Item.STATUE);
		r10.getEquipment().addItem(Item.STATUE);
		
		r2.setOpen(false);
		
		dungeon.getStart().setTransition(Direction.EAST, t1);
		r1.setTransition(Direction.SOUTH, t2, true);
		
		r2.setTransition(Direction.WEST, t3, true);
		
		r3.setTransition(Direction.SOUTH, t4, true);
		r3.setTransition(Direction.WEST, t5, true);
		
		r4.setTransition(Direction.WEST, t6, true);
		
		r5.setTransition(Direction.NORTH, t7, true);
		
		r6.setTransition(Direction.NORTH, t8, true);
		
		r7.setTransition(Direction.EAST, t9);
		r7.setTransition(Direction.NORTH, t10, true);
		
		r8.setTransition(Direction.EAST, t11, true);
		
		r9.setTransition(Direction.EAST, t12, true);
		
		return dungeon;
		
	}
	
}
