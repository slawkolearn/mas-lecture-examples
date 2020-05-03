package mt.mas.constraints_predef;

import mt.mas.ObjectPlus4;

/**
 * @author Mariusz
 *
 */
public class Employee extends ObjectPlus4 {

	private String firstName, lastName;

	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee: " + firstName + " " + lastName;
	}
	
	public static final String roleBelongsTo = "belongs to";
	public static final String manages = "manages"; 	
}
