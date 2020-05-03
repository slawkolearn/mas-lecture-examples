package mt.mas.constraints_predef;

import mt.mas.ObjectPlusPlus;

/**
 * @author Mariusz
 *
 */
public class GovernmentInstitution extends ObjectPlusPlus {
	private String name;

	/**
	 * @param nazwa
	 */
	public GovernmentInstitution(String nazwa) {
		super();
		this.name = nazwa;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Government institution: " + name;
	}		
}
