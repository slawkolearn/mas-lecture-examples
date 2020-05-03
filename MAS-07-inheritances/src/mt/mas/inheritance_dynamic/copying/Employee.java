package mt.mas.inheritance_dynamic.copying;

import java.time.LocalDate;

/**
 * @author Mariusz
 *
 */
public class Employee extends Person {
	private boolean medicalTest;
	private float salary;

	/**
	 *
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param medicalTest
	 * @param salary
	 */
	public Employee(String firstName, String lastName, LocalDate birthDate, boolean medicalTest, float salary) {
		super(firstName, lastName, birthDate);
		
		this.medicalTest = medicalTest;
		this.salary = salary;
	}

	/**
	 * Crreates an employee based on another person.
	 * @param prevPerson
	 * @param medicalTest
	 * @param salary
	 */
	public Employee(Person prevPerson, boolean medicalTest, float salary) {
		// Copy the old data
		super(prevPerson.firstName, prevPerson.lastName, prevPerson.birthDate);
		
		// Remember the new one
		this.medicalTest = medicalTest;
		this.salary = salary;
	}

	@Override
	public float getIncome() {
		return getSalary();
	}

	/**
	 *
	 * @return
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * @param
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}

	public boolean isMedicalTest() {
		return medicalTest;
	}

	public void setMedicalTest(boolean medicalTest) {
		this.medicalTest = medicalTest;
	}
}
