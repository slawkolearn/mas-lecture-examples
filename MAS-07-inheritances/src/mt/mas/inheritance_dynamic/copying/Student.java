package mt.mas.inheritance_dynamic.copying;

import java.time.LocalDate;


/**
 * @author Mariusz
 *
 */
public class Student extends Person {
	private int number;
	private float scholarship;

	public Student(String firstName, String lastName, LocalDate birthDate, int number, float scholarship) {
		super(firstName, lastName, birthDate);
		
		this.number = number;
		this.scholarship = scholarship;
	}

	public Student(Person prevPerson, int number, float scholarship) {
		// Copy the old data
		super(prevPerson.firstName, prevPerson.lastName, prevPerson.birthDate);

		this.number = number;
		this.scholarship = scholarship;
	}

	@Override
	public float getIncome() {
		return getScholarship();
	}

	public float getScholarship() {
		return scholarship;
	}

	public void setScholarship(float scholarship) {
		this.scholarship = scholarship;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
