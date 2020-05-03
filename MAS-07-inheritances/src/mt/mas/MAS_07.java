package mt.mas;

import java.time.LocalDate;

import mt.mas.inheritance_dynamic.copying.*;
import mt.mas.inheritance_multipleinheritance.WorkingStudent;


/**
 * @author Mariusz Trzaska
 * Please send any remarks to: mtrzaska@pjwstk.edu.pl
 */
public class MAS_07 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		testDisjointPolymorphic();
//		testMultipleInheritance();
//		testMultipleInheritance2();
//		testOverlappingInheritance();
//		testOverlappingInheritance2();
		testInheritanceDynamic_Copying();
	}

	/***
	 * Tests a multi-inheritance implemented using an interface.
	 */

	public static void testMultipleInheritance() {
		mt.mas.inheritance_multipleinheritance.WorkingStudent ws1 = new WorkingStudent("Tom", "White", LocalDate.of(1993, 5, 22), 1234, 3000.0f, true, 4500f);

		System.out.println(ws1);
	}

	/***
	 * Tests a multi-inheritance implemented using an interface and a composition.
	 */

	public static void testMultipleInheritance2() {
		mt.mas.inheritance_multipleinheritance2.WorkingStudent ws1 = new mt.mas.inheritance_multipleinheritance2.WorkingStudent("Tom", "White", LocalDate.of(1993, 5, 22), 1234, 3000.0f, true, 4500f);

		System.out.println(ws1);
	}

	/***
	 * Tests polymorphic method calls in the disjoint inheritance.
	 */
	
	public static void testDisjointPolymorphic() {
		mt.mas.inheritance_disjoint.polymorphism.Person p1 = new mt.mas.inheritance_disjoint.polymorphism.Employee("John", "Smith", LocalDate.of(1990, 12, 20), true, 4000.0f);
		mt.mas.inheritance_disjoint.polymorphism.Person p2 = new mt.mas.inheritance_disjoint.polymorphism.Student("Adam", "Black", LocalDate.of(1995, 10, 18), 1212, 2000.0f);
		
		System.out.println(p1.getIncome());
		System.out.println(p2.getIncome());
	}
	
	
	/***
	 * Tests an overlapping inheritance implemented using a flattened hierarchy.
	 */
	public static void testOverlappingInheritance() {
		// Create a new person who is also an employee and a student
		mt.mas.inheritance_overlapping1.Person p1 = new mt.mas.inheritance_overlapping1.Person("Jan", "Kowalski", LocalDate.of(1994, 9, 14), true, 1234);
		
		try {
			System.out.println(p1.hasMedicalTest());
			System.out.println(p1.getNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * Tests an overlapping inheritance implemented using a composition.
	 */
	public static void testOverlappingInheritance2() {
		// Create a new person who is also an employee
		mt.mas.inheritance_overlapping2.Person p1 = new mt.mas.inheritance_overlapping2.Person("Jan", "Kowalski", LocalDate.of(1994, 9, 14), true);

		try {
			System.out.println(p1.hasMedicalTest());
			System.out.println(p1.getIncome());

			// System.out.println(o1.getNumber());		// the code throws an exception because this person is not s student
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * Tests a dynamic inheritance implemented using an object copying.
	 */
	public static void testInheritanceDynamic_Copying() {
		// Create a student
		Person p1  = new mt.mas.inheritance_dynamic.copying.Student("John", "Smith", LocalDate.of(1994, 9, 14), 1212, 2000.0f);
		System.out.println(p1);

		// Create an Employee based on the Student
		p1 = new mt.mas.inheritance_dynamic.copying.Employee(p1, true, 4000.0f);
		System.out.println(p1);
		
		// Create a Pensioner based on the Employee
		p1 = new mt.mas.inheritance_dynamic.copying.Pensioner(p1, 3000.0f);
		System.out.println(p1);
	}
}
