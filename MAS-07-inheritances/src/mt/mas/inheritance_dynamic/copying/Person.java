package mt.mas.inheritance_dynamic.copying;

import java.time.LocalDate;

/**
 * @author Mariusz
 *
 */
public abstract class Person {
	protected String firstName;
	protected String lastName;
	protected LocalDate birthDate;

	public Person(String firstName, String lastName, LocalDate birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	/**
	 * Gets the total income of a person.
	 * @return
	 */
	public abstract float getIncome();

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + firstName + " " + lastName;
	}	
}
