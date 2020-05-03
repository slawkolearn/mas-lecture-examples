package mt.mas.inheritance_overlapping2;

import mt.mas.ObjectPlusPlus;

/**
 * @author Mariusz
 *
 */
public class Student extends ObjectPlusPlus {
	private int number;
	private float scholarship;

	/**
	 * @param number
	 */
	public Student(int number) {
		super();
		this.number = number;
	}

	/**
	 * @return the numerIndeksu
	 */
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public float getIncome() {
		return getScholarship();
	}


	/**
	 * @return the stypendium
	 */
	public float getScholarship() {
		return scholarship;
	}

	public void setScholarship(float scholarship) {
		this.scholarship = scholarship;
	}
}
