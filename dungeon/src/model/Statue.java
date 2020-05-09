/**
 * 
 */
package model;

/**
 * @author quentin
 *
 */
public class Statue extends Item {

	public Statue() {
		// TODO Auto-generated constructor stub
		this("statue of youth");
	}
	
	public Statue(String name) {
		super(name);
		addAction(Action.TAKE);
		addAction(Action.LEAVE);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName();
	}
	
}
