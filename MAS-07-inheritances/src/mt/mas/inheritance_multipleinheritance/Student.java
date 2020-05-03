package mt.mas.inheritance_multipleinheritance;

import java.time.LocalDate;

/**
 * @author Mariusz
 *
 */
public class Student extends Person implements IStudent {
	private int number;
	private float scholarship;

	public Student(String firstName, String lastName, LocalDate birthDate, int number, float scholarship) {
		super(firstName, lastName, birthDate);
		
		this.number = number;
		this.scholarship = scholarship;
	}

	/* (non-Javadoc)
	 * @see mt.mas.dziedziczenie_wielodziedziczenie.IStudent#getDochody()
	 */
	@Override
	public float getIncome() {
		return getScholarship();
	}


	/* (non-Javadoc)
	 * @see mt.mas.dziedziczenie_wielodziedziczenie.IStudent#getStypendium()
	 */
	public float getScholarship() {
		return scholarship;
	}


	/* (non-Javadoc)
	 * @see mt.mas.dziedziczenie_wielodziedziczenie.IStudent#setStypendium(float)
	 */
	public void setScholarship(float stypendium) {
		this.scholarship = stypendium;
	}

	@Override
	public int getNumber() {
		return number;
	}
}
