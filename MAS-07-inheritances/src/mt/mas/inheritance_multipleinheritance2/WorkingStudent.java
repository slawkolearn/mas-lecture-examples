package mt.mas.inheritance_multipleinheritance2;

import java.time.LocalDate;

/**
 * Implementation of the multi-inheritance using an interface and a composition (propagation of the operation).
 * @author Mariusz
 *
 */
public class WorkingStudent extends Employee implements IStudent {
	Student student;
	
	public WorkingStudent(String firstName, String lastName, LocalDate birthDate, int number, float scholarship, boolean medicalTest, float salary) {
		super(firstName, lastName, birthDate, medicalTest, salary);
		
		student = new Student(null, null, null, number, scholarship);   // pass nulls to prevent data redundancy (firstName, etc.)
	}
	
	@Override
	public float getIncome() {
		return super.getIncome() + getScholarship();
	}

	@Override
	public int getNumber() {
		return student.getNumber();
	}

	@Override
	public float getScholarship() {
		return student.getScholarship();
	}

	@Override
	public void setScholarship(float scholarship) {
		student.setScholarship(scholarship);
	}

	@Override
	public String toString() {
		return String.format("Working student: %s %s, scholarship: %s, salary: %s", getFirstName(), getLastName(), getScholarship(), getSalary());
	}
}
