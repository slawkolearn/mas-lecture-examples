package mt.mas.inheritance_overlapping2;

import mt.mas.ObjectPlusPlus;

public class Pensioner extends ObjectPlusPlus {
	private float pension;
	
	/**
	 * @return the emerytura
	 */
	public float getPension() {
		return pension;
	}
	
	public float getIncome() {
		return getPension();
	}	
}
