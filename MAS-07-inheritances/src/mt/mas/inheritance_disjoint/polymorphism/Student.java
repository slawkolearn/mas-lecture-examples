package mt.mas.inheritance_disjoint.polymorphism;

import java.time.LocalDate;

/**
 * @author Mariusz
 *
 */
public class Student extends Person {
	private int number;
	private float scholarship;
	

	/**
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param number
	 * @param scholarship
	 */
	public Student(String firstName, String lastName, LocalDate birthDate, int number, float scholarship) {
		super(firstName, lastName, birthDate);
		
		this.number = number;
		this.scholarship = scholarship;
	}


	@Override
	public float getIncome() {
		return getScholarship();
	}


	/**
	 * @return the stypendium
	 */
	public float getScholarship() {
		return scholarship;
	}


	/**
	 * @param stypendium the stypendium to set
	 */
	public void setScholarship(float stypendium) {
		this.scholarship = stypendium;
	}
}
