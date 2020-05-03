package mt.mas.inheritance_disjoint;

import java.time.LocalDate;

/**
 * @author Mariusz
 *
 */
public class Pensioner extends Person {
	private float pension;

	public Pensioner(String firstName, String lastName, LocalDate birthDate, float pension) {
		super(firstName, lastName, birthDate);
		this.pension = pension;
	}

	public float getPension() {
		return pension;
	}

	public void setPension(float pension) {
		this.pension = pension;
	}

	@Override
	public float getIncome() {
		return getPension();
	}

}
