package model;

public enum Contributor {

	RAPH ("Raphaël", "GUEZ", "for the music"),
	MYSELF ("Quentin", "GUEZ", "(myself) for developping this game");
	
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
