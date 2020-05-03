package mt.mas.inheritance_disjoint;

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

	@Override
	public float getIncome() {
		return getScholarship();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public float getScholarship() {
		return scholarship;
	}

	public void setScholarship(float scholarship) {
		this.scholarship = scholarship;
	}
}
