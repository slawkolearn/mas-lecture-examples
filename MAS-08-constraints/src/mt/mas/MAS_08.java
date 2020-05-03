package mt.mas;

import mt.mas.constraints_predef.*;
import static mt.mas.constraints_predef.Employee.*;
import static mt.mas.constraints_predef.Group.*;

/**
 * @author Mariusz
 *
 */
public class MAS_08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		testAttributeConstraint();
//		testSubset_auto();
		testSubset_manual();
//		testXor();
	}

	private static void testAttributeConstraint() {
		var employee = new mt.mas.constraints_attributes.Employee(mt.mas.constraints_attributes.Employee.minimumSalary + 1);
		try {
			employee.setSalary(mt.mas.constraints_attributes.Employee.minimumSalary * 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests "subset" constraint - manual validation of the subset constraint.
	 */
	private static void testSubset_manual() {
		var employee = new mt.mas.constraints_predef.Employee("John", "Smith");
		var group = new Group("Group no 1");
		
		try {
			// Add ordinary link
			employee.addLink(roleBelongsTo, roleConsistsOf, group);
	
			// Check if there is a super link
			if(employee.isLink(roleBelongsTo, group)) {
				// There is a super link => add a subset link
				employee.addLink(manages, roleManagedBy, group);
			}
			else {
				// No super link
				System.out.println("No super link for the role: " + roleBelongsTo);
			}
			
			// Show links info
			employee.showLinks(roleBelongsTo, System.out);
			employee.showLinks(manages, System.out);

		} catch (Exception e) {
			// Error
			e.printStackTrace();
		}
	}
	
	/**
	 * Tests "subset" constraint - automatic validation of the subset constraint
	 */
	private static void testSubset_auto() {
		var employee = new mt.mas.constraints_predef.Employee("John", "Smith");
		var group = new Group("Group no 1");
		
		try {
			// Add the ordinary link
			employee.addLink(roleBelongsTo, roleConsistsOf, group);

			employee.addLink_subset(manages, roleManagedBy, roleBelongsTo, group);

			// Show links info
			employee.showLinks(roleBelongsTo, System.out);
			employee.showLinks(manages, System.out);

		} catch (Exception e) {
			// Error
			e.printStackTrace();
		}
	}
	
	/**
	 * Tests "xor" constraint
	 */
	private static void testXor() {
		final String roleCustomer = "customer";
		final String roleConsultant = "consultant";
		final String roleEmployer = "employer";
		final String roleEmployee = "employee";
		
		var person = new Person("John", "Smith");
		var company = new Company("Company 001");
		var governmentInstitution = new GovernmentInstitution("Institution 02");
		
		try {
			// Add info about role constrained by the XOR
			person.addXorRole(roleCustomer);
			person.addXorRole(roleEmployer);
			
			// Add link no 1
			person.addLinkXor(roleCustomer, roleConsultant, company);

			// Add link no 2 {xor} ==> exception
			// o.dodajPowiazanie_xor(rolaPracodawca, rolaPracownik, i);
			
			// Show links info
			person.showLinks(roleCustomer, System.out);
			
		} catch (Exception e) {
			// Error
			e.printStackTrace();
		}		
	}	
}
