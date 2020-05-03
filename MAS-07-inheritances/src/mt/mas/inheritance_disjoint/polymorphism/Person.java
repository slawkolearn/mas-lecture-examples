package mt.mas.inheritance_disjoint.polymorphism;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author Mariusz
 *
 */
public abstract class Person {
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 */
	public Person(String firstName, String lastName, LocalDate birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	/**
	 * Gets total income of the person (different for various subclasses).
	 * @return
	 */
	public abstract float getIncome();
}
