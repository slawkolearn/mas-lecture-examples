package mt.mas.inheritance_dynamic.copying;

import java.time.LocalDate;

/**
 * @author Mariusz
 *
 */
public class Pensioner extends Person {
	private float pension;

	public Pensioner(String firstName, String lastName, LocalDate birthDate, float pension) {
		super(firstName, lastName, birthDate);
		
		this.pension = pension;
	}

	/**
	 * Creates a new pensioner based on another person.
	 * @param prevPerson
	 * @param pension
	 */
	public Pensioner(Person prevPerson, float pension) {
		// Copy the old data
		super(prevPerson.firstName, prevPerson.lastName, prevPerson.birthDate);
		
		this.pension = pension;
	}

	public float getPension() {
		return pension;
	}

	public void setPension(float pension) {
		this.pension = pension;
	}

	@Override
	public float getIncome() {		
		return getPension();
	}
}
