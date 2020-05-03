package mt.mas.inheritance_multipleinheritance2;

public interface IStudent {

	public abstract float getIncome();

	/**
	 * @return the stypendium
	 */
	public abstract float getScholarship();

	/**
	 * @param scholarship the stypendium to set
	 */
	public abstract void setScholarship(float scholarship);

	/**
	 * Zwraca numer indeksu.
	 * @return
	 */
	public abstract int getNumber();
}