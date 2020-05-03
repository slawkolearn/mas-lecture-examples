package mt.mas.inheritance_disjoint;

import java.time.LocalDate;

/**
 * @author Mariusz
 *
 */
public abstract class Person {
	private String firstName;
	private String lastName;
	private LocalDate birthDate;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
}
