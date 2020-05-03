package mt.mas.inheritance_overlapping2;

import mt.mas.ObjectPlusPlus;

/**
 * @author Mariusz
 *
 */
public class Employee extends ObjectPlusPlus {
	private boolean medicalTest;
	private float salary;

	/**
	 * @param badaniaLekarskie
	 */
	public Employee(boolean medicalTest) {
		super();
		this.medicalTest = medicalTest;
	}

	/**
	 * @return the badaniaLekarskie
	 */
	public boolean isMedicalTest() {
		return medicalTest;
	}

	/**
	 * @param badaniaLekarskie the badaniaLekarskie to set
	 */
	public void setMedicalTest(boolean medicalTest) {
		this.medicalTest = medicalTest;
	}
	
	public float getIncome() {
		return getSalary();
	}

	/**
	 * @return the pensja
	 */
	public float getSalary() {
		return salary;
	}	
}
