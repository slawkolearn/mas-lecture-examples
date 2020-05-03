package mt.mas.inheritance_multipleinheritance;

import java.time.LocalDate;

/**
 * Implementation of the multi-inheritance using an interface (without a composition).
 * @author Mariusz
 *
 */
public class WorkingStudent extends Employee implements IStudent {
	private int number;
	private float scholarship;
	
	public WorkingStudent(String firstName, String lastName, LocalDate birthDate, int number, float scholarship, boolean medicalTest, float salary) {
		super(firstName, lastName, birthDate, medicalTest, salary);

		this.number = number; 
		this.scholarship = scholarship;
	}
	
	@Override
	public float getScholarship() {
		return scholarship;
	}
	@Override
	public void setScholarship(float scholarship) {
		this.scholarship = scholarship;
	}

	@Override
	public float getIncome() {
		return super.getIncome() + getScholarship();
	}
	
	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return String.format("Working student: %s %s, scholarship: %s, salary: %s", getFirstName(), getLastName(), getScholarship(), getSalary());
	}
}
