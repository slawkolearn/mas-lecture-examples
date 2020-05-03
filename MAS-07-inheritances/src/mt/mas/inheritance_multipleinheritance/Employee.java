package mt.mas.inheritance_multipleinheritance;

import java.time.LocalDate;

/**
 * @author Mariusz
 *
 */
public class Employee extends Person {
	private boolean medicalTest;
	private float salary;

	/**
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


	@Override
	public float getIncome() {
		return getSalary();
	}

	public float getSalary() {
		return salary;
	}

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
