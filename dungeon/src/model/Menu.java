package model;

import java.util.ArrayList;

/**
 * A class that contains the menu specifications
 * @author quentin
 *
 */
public class Menu {

	private boolean silence;
	private ArrayList<Action> actions;
	
	public Menu() {
		
		actions = new ArrayList<>();
		actions.add(Action.START);
//		actions.add(Action.LEVEL);
//		actions.add(Action.MAKE);
		actions.add(Action.SILENCE);
		actions.add(Action.CREDITS);
		actions.add(Action.QUIT);
		
	}
	
	/**
	 * @return the silencew
	 */
	public boolean isSilence() {
		return silence;
	}

	/**
	 * @param silence the silence to set
	 */
	public void setSilence(boolean silence) {
		
		int index = (this.silence) ? actions.indexOf(Action.NOISY) : actions.indexOf(Action.SILENCE);
				
		actions.set(index, (silence) ? Action.NOISY : Action.SILENCE);
		
		
		this.silence = silence;
		
	}

	/**
	 * @return the actions
	 */
	public ArrayList<Action> getActions() {
		return actions;
	}

}
