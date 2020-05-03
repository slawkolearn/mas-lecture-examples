package mt.mas.inheritance_disjoint.polymorphism;

import java.time.LocalDate;

/**
 * @author Mariusz
 *
 */
public class Pensioner extends Person {
	private float pension;
	
	/**
	 * @return the emerytura
	 */
	public float getPension() {
		return pension;
	}

	/**
	 * @param emerytura the emerytura to set
	 */
	public void setPension(float emerytura) {
		this.pension = emerytura;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param pension
	 */
	public Pensioner(String firstName, String lastName, LocalDate birthDate, float pension) {
		super(firstName, lastName, birthDate);
		
		this.pension = pension;
	}

	@Override
	public float getIncome() {		
		return getPension();
	}
}
