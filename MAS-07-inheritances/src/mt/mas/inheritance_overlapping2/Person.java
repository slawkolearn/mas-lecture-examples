package mt.mas.inheritance_overlapping2;

import java.time.LocalDate;

import mt.mas.ObjectPlusPlus;

/**
 * Implementation of the overlapping inheritance with a composition.
 * @author Mariusz
 *
 */
public class Person extends ObjectPlusPlus {
	private String firstName;
	private String lastName;
	private LocalDate birthDate;

	public Person(String firstName, String lastName, LocalDate birthDate) {
		super();	// Required by the ObjectPlusPlus

		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	/**
	 * Creates a person as an employee.
	 */
	public Person(String firstName, String lastName, LocalDate birthDate, boolean medicalTest) {
		super();	// Required by the ObjectPlusPlus

		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		
		// "Changes" a person into an employee
		addEmployee(medicalTest);
	}
	
	/**
	 * Adds a "subclass" Employee (bypassing of the overlapping inheritance).
	 */
	private void addEmployee(boolean medicalTest) {
		// Creation of the employee part
		Employee p = new Employee(medicalTest);
		
		// Adding an employee as a link 
		// We use a method provided by the ObjectPlusPlus
		this.addLink(roleNameEmployee, roleNameGeneralization, p);
	}
	
	/**
	 * Adds a "subclass" Student (bypassing of the overlapping inheritance).
	 */
	private void addStudent(int number) throws Exception {
		// Creation of the student part
		Student s = new Student(number);
		
		// Adding a student as a link 
		// We use a method provided by the ObjectPlusPlus
		this.addLink(roleNameStudent, roleNameGeneralization, s);		
	}
	
	/**
	 * Adds a "subclass" Pensioner (bypassing of the overlapping inheritance).
	 */
	private void addPensioner() throws Exception {
		// Creation of the pensioner part
		Pensioner e = new Pensioner();
		
		// Adding a pensioner as a link 
		// We use a method provided by the ObjectPlusPlus
		this.addLink(roleNamePensioner, roleNameGeneralization, e);		
	}
	
	/**
	 * Indicates if the employee has a medical test
	 * @return
	 * @throws Exception if it is not an employee.
	 */
	public boolean hasMedicalTest() throws Exception {
		// get an employee object
		try {
			ObjectPlusPlus[] obj = this.getLinks(roleNameEmployee);
			return ((Employee) obj[0]).isMedicalTest();			
		} catch (Exception e) {
			// Probably this is an exception telling that this is not an employee
			// (we should introduce different exception classes)
			throw new Exception("The object is not an employee!");
		}		
	}

	/**
	 * Gets a student number.
	 * @return
	 * @throws Exception if it is not a student.
	 */
	public int getNumber() throws Exception {
		// get a student object
		try {
			ObjectPlusPlus[] obj = this.getLinks(roleNameStudent);
			return ((Student) obj[0]).getNumber();			
		} catch (Exception e) {
			// Probably this is an exception telling that this is not a student
			// (we should introduce different exception classes)
			throw new Exception("The object is not a Student!");
		}		
	}
	
	/**
	 * Gets an income of the person (based on person's kind).
	 * @return
	 * @throws Exception 
	 */
	public float getIncome() throws Exception {
		float income = 0.0f;
		
		if(this.anyLink(roleNameEmployee)) {
			// Employee
			ObjectPlusPlus[] obj = this.getLinks(roleNameEmployee);
						
			// ==> add employee's income
			income += ((Employee) obj[0]).getIncome(); 
		}
		
		if(this.anyLink(roleNameStudent)) {
			// Student
			ObjectPlusPlus[] obj = this.getLinks(roleNameStudent);
						
			// ==> add Student's income
			income += ((Student) obj[0]).getIncome(); 
		}
		
		if(this.anyLink(roleNamePensioner)) {
			// Pensioner
			ObjectPlusPlus[] obj = this.getLinks(roleNamePensioner);
						
			// ==> ==> add pensioner's income
			income += ((Pensioner) obj[0]).getIncome(); 
		}

		return income;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	private static String roleNameEmployee = "specializationEmployee";
	private static String roleNamePensioner = "specializationPensioner";
	private static String roleNameStudent = "specializationStudent";
	private static String roleNameGeneralization = "generalization";
}
