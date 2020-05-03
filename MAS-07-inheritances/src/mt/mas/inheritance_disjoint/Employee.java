package mt.mas.inheritance_disjoint;

import java.time.LocalDate;

/**
 * @author Mariusz
 *
 */
public class Employee extends Person {
	private boolean medicalTest;
	private float salary;

	public Employee(String firstName, String lastName, LocalDate birthDate, boolean medicalTest, float salary) {
		super(firstName, lastName, birthDate);
		this.medicalTest = medicalTest;
		this.salary = salary;
	}

	public boolean hasMedicalTest() {
		return medicalTest;
	}

	public void setMedicalTest(boolean medicalTest) {
		this.medicalTest = medicalTest;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public float getIncome() {
		return getSalary();
	}
}
