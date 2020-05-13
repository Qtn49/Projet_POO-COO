package model;

public class Chest {

	private Item item;

	/**
	 * @param item
	 */
	public Chest(Item item) {
		super();
		this.item = item;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}

}