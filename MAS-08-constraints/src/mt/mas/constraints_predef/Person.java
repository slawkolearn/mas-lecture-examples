package mt.mas.constraints_predef;

import mt.mas.ObjectPlus4;

/**
 * @author Mariusz
 *
 */
public class Person extends ObjectPlus4 {

	private String firstName, lastName;

	/**
	 * @param imie
	 * @param nazwisko
	 */
	public Person(String firstName, String nazwisko) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person: " + firstName + " " + lastName;
	}
	
	public static final String roleBelongsTo = "belongs to";
	public static final String manages = "manages"; 	
}
