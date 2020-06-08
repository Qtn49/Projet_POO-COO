package model;

/**
 * an enumeration to list all the contributors of this project (lol)
 * @author quentin
 *
 */
public enum Contributor {

	RAPH ("Raphaël", "GUEZ", "for the music"),
	MYSELF ("Quentin", "GUEZ", "(myself) for developping this game no thanks for the annoying sounds though"),
	LISA ("Lisa", "Aslim", "for helping me in english and make this project better");
	
	private String firstName;
	private String lastName;
	private String contribution;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param contribution
	 */
	private Contributor(String firstName, String lastName, String contribution) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contribution = contribution;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the contribution
	 */
	public String getContribution() {
		return contribution;
	}
	
	
	
}
