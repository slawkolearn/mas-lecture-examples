package mt.mas.constraints_predef;

import mt.mas.ObjectPlus4;

/**
 * @author Mariusz
 *
 */
public class Company extends ObjectPlus4 {
	private String nazwa;

	/**
	 * @param nazwa
	 */
	public Company(String nazwa) {
		super();
		this.nazwa = nazwa;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Firma: " + nazwa;
	}	
}
