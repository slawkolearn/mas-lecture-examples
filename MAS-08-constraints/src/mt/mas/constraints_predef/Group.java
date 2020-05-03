package mt.mas.constraints_predef;

import mt.mas.ObjectPlus4;

/**
 * @author Mariusz
 *
 */
public class Group extends ObjectPlus4 {
	private String name;

	/**
	 * @param name
	 */
	public Group(String name) {
		super();
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Group: " + name;
	}
	
	public static final String roleConsistsOf = "Consists of"; 
	public static final String roleManagedBy = "Managed by"; 	
}
